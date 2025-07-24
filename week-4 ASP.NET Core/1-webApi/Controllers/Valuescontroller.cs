using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;

namespace webApi.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class ValuesController : ControllerBase
    {
        private static List<string> values = new List<string> { "vamshi","surya","sai" };

        [HttpGet]
        public ActionResult<IEnumerable<string>> Get() => Ok(values);

        [HttpPost]
        public ActionResult Post([FromBody] string value)
        {
            values.Add(value);
            return Ok();
        }
    }
}
