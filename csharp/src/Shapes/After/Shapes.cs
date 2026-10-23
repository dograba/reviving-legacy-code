namespace Shapes.After;

/// <summary>
/// AFTER: Single Responsibility Principle applied (Chapter 7).
/// Each shape owns its own area calculation behind a common interface.
/// </summary>
public interface IShape
{
    double CalculateArea();
}

public class Circle : IShape
{
    private readonly double _radius;

    public Circle(double radius) => _radius = radius;

    public double CalculateArea() => Math.PI * Math.Pow(_radius, 2);
}

public class Square : IShape
{
    private readonly double _side;

    public Square(double side) => _side = side;

    public double CalculateArea() => Math.Pow(_side, 2);
}

public class Rectangle : IShape
{
    private readonly double _length;
    private readonly double _width;

    public Rectangle(double length, double width)
    {
        _length = length;
        _width = width;
    }

    public double CalculateArea() => _length * _width;
}

/// <summary>
/// Returns a value instead of writing to a label, so it can be unit-tested
/// without a form. Displaying the result is the UI layer's job.
/// </summary>
public class AreaCalculator
{
    public double Calculate(IShape shape) => shape.CalculateArea();
}
