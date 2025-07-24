using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Authorization;
using System.Collections.Generic;

namespace MyWebApi.Controllers
{
    [ApiController]
    [Route("[controller]")]
    [Authorize]
    public class EmployeeController : ControllerBase
    {
        private static List<Employee> employees = new List<Employee>
        {
            new Employee { Id = 1, Name = "Alice" },
            new Employee { Id = 2, Name = "Bob" }
        };

        [HttpGet]
        public IActionResult Get() => Ok(employees);
    }

   
}
