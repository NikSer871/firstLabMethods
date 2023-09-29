import java.util.function.Function;

public class Decision {
    public static double findRoot(Function<Double, Double> equation, double a, double b, double epsilon) {
        if (equation.apply(a) * equation.apply(b) > 0) {
            System.out.println("Wrong numbers!!!");
            System.exit(-1);
        }
        double fixedNumber = a;
        double valuesA;
        double valuesB;
        double newValue;
        double valueOfFunction;
        while (true) {
            valuesA = equation.apply(a);
            valuesB = equation.apply(b);
            newValue = a - (valuesA * (a - b)) / (valuesA - valuesB);
            valueOfFunction = equation.apply(newValue);
            if (Math.abs(fixedNumber - newValue) < epsilon) {
                return newValue;
            }
            if (valuesA * valueOfFunction > 0) {
                a = newValue;
            } else {
                b = newValue;
            }
            fixedNumber = newValue;
        }
    }

    public static void main(String[] args) {

        Function<Double, Double> equation = (x) -> 21 * Math.pow(x, 5) - (43.3 * Math.pow(x, 4)) + (10.2 * Math.pow(x, 2)) - (51 * x) - 9.7;
        double a = -5;
        double b = 5;
        double err = 0.001;
        double root = findRoot(equation, a, b, err);
        System.out.println("x = " + root);
        System.out.println("F(x) = " + equation.apply(root));

    }
}
