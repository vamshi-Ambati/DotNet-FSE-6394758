using Confluent.Kafka;

var config = new ProducerConfig { BootstrapServers = "localhost:9092" };
string topic = "chat-messages";

using var producer = new ProducerBuilder<Null, string>(config).Build();

Console.WriteLine("Enter chat messages (type 'exit' to quit):");
while (true)
{
    string? message = Console.ReadLine();
    if (message == "exit") break;

    await producer.ProduceAsync(topic, new Message<Null, string> { Value = message });
    Console.WriteLine($"Sent: {message}");
}
