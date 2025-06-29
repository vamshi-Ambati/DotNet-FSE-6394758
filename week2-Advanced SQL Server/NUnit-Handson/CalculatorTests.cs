using System;
using NUnit.Framework;

public class Calculator
{
    public int Add(int a, int b)
    {
        return a + b;
    }
}
[TestFixture]
public class CalculatorTests
{
    private Calculator calc;

    [SetUp]
    public void SetUp()
    {
        calc = new Calculator();
    }

    [Test]
    [TestCase(2, 3, 5)]
    [TestCase(0, 0, 0)]
    public void TestAddition(int a, int b, int expected)
    {
        int result = calc.Add(a, b);
        Assert.That(result, Is.EqualTo(expected));
    }
}
