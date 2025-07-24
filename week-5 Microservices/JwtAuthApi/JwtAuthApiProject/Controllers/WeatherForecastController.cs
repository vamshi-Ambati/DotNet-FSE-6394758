using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Authorization;
using JwtAuthApiProject.Models;

namespace JwtAuthApiProject.Controllers
{
    [ApiController]
    [Route("[controller]")]
    [Authorize]
    public class WeatherForecastController : ControllerBase
    {
        private static readonly string[] Summaries = new[]
        {
            "Freezing", "Hot", "Chilly", "Warm", "Cool", "Mild"
        };

        private readonly ILogger<WeatherForecastController> _logger;

        public WeatherForecastController(ILogger<WeatherForecastController> logger)
        {
            _logger = logger;
        }

        [HttpGet(Name = "GetWeatherForecast")]
        public IEnumerable<WeatherForecast> Get()
        {
            var username = User.Identity?.Name ?? "Unknown";
            _logger.LogInformation($"User {username} accessed weather forecast.");

            return Enumerable.Range(1, 5).Select(i => new WeatherForecast
            {
                Date = DateOnly.FromDateTime(DateTime.Now.AddDays(i)),
                TemperatureC = Random.Shared.Next(-20, 55),
                Summary = Summaries[Random.Shared.Next(Summaries.Length)]
            });
        }

        [HttpGet("public")]
        [AllowAnonymous]
        public string GetPublicData()
        {
            return "This is public data - token not needed!";
        }
    }
}
