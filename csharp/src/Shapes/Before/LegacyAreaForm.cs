namespace Shapes.Before;

/// <summary>
/// BEFORE: calculation logic tangled with the user interface (Chapter 7).
///
/// In the book this is a WinForms form. Here the text boxes and the result label
/// are plain string properties, so the legacy coupling compiles and can be
/// characterised in tests without a UI. Parsing, calculation and display all
/// live in one place, which is exactly the problem.
/// </summary>
public class LegacyAreaForm
{
    // Stand-ins for the form's controls
    public string TxtRadius { get; set; } = "";
    public string TxtSide { get; set; } = "";
    public string TxtLength { get; set; } = "";
    public string TxtWidth { get; set; } = "";
    public string LblResult { get; private set; } = "";

    private double _radius;
    private double _side;
    private double _length;
    private double _width;

    public void CalculateCircleArea()
    {
        _radius = double.Parse(TxtRadius);
        double area = Math.PI * Math.Pow(_radius, 2);
        LblResult = $"The area of the circle is: {area}";
    }

    public void CalculateSquareArea()
    {
        _side = double.Parse(TxtSide);
        double area = Math.Pow(_side, 2);
        LblResult = $"The area of the square is: {area}";
    }

    public void CalculateRectangleArea()
    {
        _length = double.Parse(TxtLength);
        _width = double.Parse(TxtWidth);
        double area = _length * _width;
        LblResult = $"The area of the rectangle is: {area}";
    }
}
