using System.Globalization;
using Shapes.After;
using Shapes.Before;
using Xunit;

namespace Shapes.Tests;

/// <summary>
/// Step 1: characterise the legacy form's output.
/// Step 2: prove the refactored classes calculate exactly the same areas.
/// </summary>
public class AreaEquivalenceTests
{
    public AreaEquivalenceTests()
    {
        // The legacy code parses and formats with the current culture,
        // so pin it for repeatable results on any machine.
        CultureInfo.CurrentCulture = CultureInfo.InvariantCulture;
    }

    private static double AreaFromLabel(string label) =>
        double.Parse(label[(label.LastIndexOf(": ", StringComparison.Ordinal) + 2)..],
            CultureInfo.InvariantCulture);

    [Theory]
    [InlineData("0")]
    [InlineData("1")]
    [InlineData("2.5")]
    [InlineData("100")]
    public void CircleAreaMatchesLegacy(string radius)
    {
        var form = new LegacyAreaForm { TxtRadius = radius };
        form.CalculateCircleArea();

        var refactored = new AreaCalculator().Calculate(
            new Circle(double.Parse(radius, CultureInfo.InvariantCulture)));

        Assert.StartsWith("The area of the circle is: ", form.LblResult);
        Assert.Equal(AreaFromLabel(form.LblResult), refactored);
    }

    [Theory]
    [InlineData("0")]
    [InlineData("3")]
    [InlineData("4.75")]
    public void SquareAreaMatchesLegacy(string side)
    {
        var form = new LegacyAreaForm { TxtSide = side };
        form.CalculateSquareArea();

        var refactored = new AreaCalculator().Calculate(
            new Square(double.Parse(side, CultureInfo.InvariantCulture)));

        Assert.Equal(AreaFromLabel(form.LblResult), refactored);
    }

    [Theory]
    [InlineData("2", "3")]
    [InlineData("0", "10")]
    [InlineData("1.5", "4.5")]
    public void RectangleAreaMatchesLegacy(string length, string width)
    {
        var form = new LegacyAreaForm { TxtLength = length, TxtWidth = width };
        form.CalculateRectangleArea();

        var refactored = new AreaCalculator().Calculate(new Rectangle(
            double.Parse(length, CultureInfo.InvariantCulture),
            double.Parse(width, CultureInfo.InvariantCulture)));

        Assert.Equal(AreaFromLabel(form.LblResult), refactored);
    }

    [Fact]
    public void CurrentBehaviour_LegacyFormThrowsOnInvalidInput()
    {
        // The legacy form crashes on bad input. The refactored code validates instead.
        var form = new LegacyAreaForm { TxtRadius = "abc" };
        Assert.Throws<FormatException>(() => form.CalculateCircleArea());
    }

    [Theory]
    [InlineData("abc")]
    [InlineData("")]
    [InlineData("-1")]
    [InlineData(null)]
    public void RefactoredInputRejectsInvalidLengths(string? text)
    {
        Assert.False(LengthInput.TryParse(text, CultureInfo.InvariantCulture, out _));
    }

    [Fact]
    public void RefactoredInputAcceptsValidLength()
    {
        Assert.True(LengthInput.TryParse("2.5", CultureInfo.InvariantCulture, out var value));
        Assert.Equal(2.5, value);
    }
}
