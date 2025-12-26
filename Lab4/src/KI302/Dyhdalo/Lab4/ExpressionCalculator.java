package KI302.Dyhdalo.Lab4;

public class ExpressionCalculator {

    public double compute(double x) throws CalculationException {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            throw new CalculationException("x має бути скінченним числом");
        }
        if (Math.abs(x) <= 0) {
            throw new CalculationException("Ділення на нуль: 3x = 0 при x = 0");
        }
        // tg(x) = sin(x)/cos(x)
        if (Math.abs(Math.cos(x)) <= 0) {
            throw new CalculationException("tg(x) не визначена");
        }

        double y = Math.tan(x) / (3.0 * x);

        if (Double.isNaN(y) || Double.isInfinite(y)) {
            throw new CalculationException("Результат не є скінченним числом");
        }
        return y;
    }
}
