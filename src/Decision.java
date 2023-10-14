import java.util.function.Function;

public class Decision {
    public static double findRoot(Function<Double, Double> equation, double a, double b, double epsilon) {
        if (equation.apply(a) * equation.apply(b) > 0) {
            System.out.println("Wrong numbers!!!");
            System.exit(-1);
        }
        int iterator = 1;
        double fixedNumber = a;
        double valuesA;
        double valuesB;
        double newValue;
        double valueOfFunction;
        while (true) {
            valuesA = equation.apply(a);
            valuesB = equation.apply(b);
            newValue = a - (valuesA * (a - b)) / (valuesA - valuesB);
            System.out.printf("%s : x = %.4f", iterator, newValue);
            System.out.println();
            iterator++;
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
        double a = -3;
        double b = 4;
        double err = 0.00000001;
        double root = findRoot(equation, a, b, err);
        System.out.printf("x = %.4f \n", root);
        System.out.printf("F(x) = %.4f", equation.apply(root));

    }
}
