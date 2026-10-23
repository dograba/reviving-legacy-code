using System.Globalization;

namespace Shapes.After;

/// <summary>
/// Input validation moved out of the calculation: the legacy code called
/// double.Parse on raw text and threw on bad input. This returns false instead,
/// so the UI can show a friendly message.
/// </summary>
public static class LengthInput
{
    public static bool TryParse(string? text, IFormatProvider? culture, out double value)
    {
        if (double.TryParse(text, NumberStyles.Float, culture ?? CultureInfo.CurrentCulture, out value)
            && value >= 0 && !double.IsInfinity(value))
        {
            return true;
        }

        value = 0;
        return false;
    }
}
