using System;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;

class Program
{
    static async Task Main(string[] args)
    {
        using var context = new AppDbContext();

        // Insert sample data if needed
        if (!context.Products.Any())
        {
            var category = new Category { Name = "Electronics" };
            context.Categories.Add(category);
            context.Products.Add(new Product { Name = "Smartphone", Price = 25000, Category = category });
            context.SaveChanges();
        }

        // Retrieve and display all products
        var products = await context.Products.ToListAsync();
        foreach (var p in products)
            Console.WriteLine($"{p.Name} - ₹{p.Price}");

        // Find by ID
        var product = await context.Products.FindAsync(1);
        Console.WriteLine($"Found: {product?.Name}");

        // FirstOrDefault with condition
        var expensive = await context.Products.FirstOrDefaultAsync(p => p.Price > 20000);
        Console.WriteLine($"Expensive: {expensive?.Name}");
    }
}