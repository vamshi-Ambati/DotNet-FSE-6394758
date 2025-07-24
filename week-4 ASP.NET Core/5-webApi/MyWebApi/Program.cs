using Microsoft.IdentityModel.Tokens;
using System.Text;
var builder = WebApplication.CreateBuilder(args);

// ---------------- Core Service Registrations ----------------

// Add OpenAPI/Swagger support (already present)
builder.Services.AddOpenApi();

// Add CORS (Cross-Origin Resource Sharing)
builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowLocalhost",
        policy => policy.WithOrigins("http://localhost:3000") // Change as needed
                        .AllowAnyHeader()
                        .AllowAnyMethod());
});

// Add Authentication (JWT Bearer example)


var securityKey = "mysuperdupersecret";
var symmetricSecurityKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(securityKey));

builder.Services.AddAuthentication("Bearer")
    .AddJwtBearer("Bearer", options =>
    {
        options.TokenValidationParameters = new TokenValidationParameters
        {
            ValidateIssuer = true,
            ValidateAudience = true,
            ValidateLifetime = true,
            ValidateIssuerSigningKey = true,
            ValidIssuer = "mySystem",
            ValidAudience = "myUsers",
            IssuerSigningKey = symmetricSecurityKey
        };
    });

// Add Authorization if needed
builder.Services.AddAuthorization();

// ---------------- End Core Service Registrations ------------

var app = builder.Build();

// ---------------- Middleware Pipeline -----------------------

if (app.Environment.IsDevelopment())
{
    app.MapOpenApi();
}

// Use CORS
app.UseCors("AllowLocalhost");

// Use Authentication and Authorization
app.UseAuthentication();
app.UseAuthorization();

app.UseHttpsRedirection();

var summaries = new[]
{
    "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
};

app.MapGet("/weatherforecast", () =>
{
    var forecast = Enumerable.Range(1, 5).Select(index =>
        new WeatherForecast
        (
            DateOnly.FromDateTime(DateTime.Now.AddDays(index)),
            Random.Shared.Next(-20, 55),
            summaries[Random.Shared.Next(summaries.Length)]
        ))
        .ToArray();
    return forecast;
})
.WithName("GetWeatherForecast");

// Example of a protected endpoint
app.MapGet("/secure", () => "This is a protected endpoint!")
   .RequireAuthorization();

app.Run();

record WeatherForecast(DateOnly Date, int TemperatureC, string? Summary)
{
    public int TemperatureF => 32 + (int)(TemperatureC / 0.5556);
}
