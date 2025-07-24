using Confluent.Kafka;

var config = new ConsumerConfig
{
    BootstrapServers = "localhost:9092",
    GroupId = "chat-group",
    AutoOffsetReset = AutoOffsetReset.Earliest
};

string topic = "chat-messages";

using var consumer = new ConsumerBuilder<Ignore, string>(config).Build();
consumer.Subscribe(topic);

Console.WriteLine("Waiting for chat messages...");
while (true)
{
    var consumeResult = consumer.Consume();
    Console.WriteLine($"Received: {consumeResult.Message.Value}");
}
