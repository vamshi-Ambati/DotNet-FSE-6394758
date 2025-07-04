public class Product
{
    public int Id { get; set; }
    public string Name { get; set; } = null!; // Suppress warning, EF will set this
    public decimal Price { get; set; }
    public int CategoryId { get; set; }
    public Category Category { get; set; } = null!; // Suppress warning
}
