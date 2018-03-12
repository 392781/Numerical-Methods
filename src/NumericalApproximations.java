/*
    Name: Ronald Lencevicius
    Problems 5 (bisection, 8 (bisection + false), and approx of sin(1) using Kashi
 */

public class NumericalApproximations {
    private static int iterations;
    private static double a, b, c, fA, fB, fC, error;

    private static double f(double x, int functionNumber) {
        if (functionNumber == 0) {
            return x * (Math.cosh(50/x) - 1) - 10;
        } else if (functionNumber == 1) {
            return x * (x * (x + 2) + 10) - 20;
        } else {
            return 0.0;
        }
    }

    public static void bisection(double a, double b, double iterations, int functionNumber) {
        System.out.println("Iteration |        a        |        b        |        c        |      error      |");;
        for (int i = 0; i < iterations; i++) {
            c       = (a + b) / 2.0;
            error   = Math.abs(a - c);

            System.out.printf("%9d | %-15.11f | %-15.11f | %-15.11f | %-15.11f | %n", i, a, b, c, error);

            if (f(a, functionNumber) * f(c, functionNumber) < 0) {
                b = c;
            } else {
                a = c;
            }
        }
    }

    public static void falsePosition(double a, double b, double iterations, int functionNumber) {
        System.out.println("Iteration |        a        |        b        |        c        |      error      |");;
        for (int i = 0; i < iterations; i++) {
            c       = (a*f(b,functionNumber) - b*f(a,functionNumber)) / (f(b,functionNumber) - f(a,functionNumber));
            error   = Math.abs(a - c);

            if (f(a,functionNumber) * f(b, functionNumber) > 0) {
                a = c;
            } else {
                b = c;
            }
            System.out.printf("%9d | %-15.11f | %-15.11f | %-15.11f | %-15.11f | %n", i, a, b, c, error);


        }
    }

    public static void Kashi(double error) {
        double sin1 = Math.sin(1);
        double sin3 = (Math.pow(2, 0.5) / 16) * ((Math.pow(5, 0.5) - 1) * (Math.pow(3, 0.5) + 1) - (Math.pow(10 + 2 * Math.pow(5, 0.5), 0.5)) * (Math.pow(3, 0.5) - 1));
        double aprx = sin3/3;
        int x = 0;
        System.out.println(Math.sin(1));
        System.out.println("Iteration |    Approximation    |        error        ");
        System.out.printf("%9d | %-19.17f | %-19.17f %n", x, aprx, Math.abs(sin1 - aprx));
        while (Math.abs(sin1 - aprx) > error) {
            x++;
            aprx = ((4 / 3) * Math.pow(aprx,3)) + sin3/3;
            System.out.printf("%9d | %-19.17f | %-19.17f %n", x, aprx, Math.abs(sin1 - aprx));
        }
    }

    public static void main(String[] args) {
        iterations = 20;

        System.out.println("Equation: x * (cosh(x/50) - 1) - 10, bisection");
        bisection(126, 127, iterations, 0);

        System.out.println("\nEquation: x^3 + 2x^2 + 10x - 20, bisection");
        bisection(1,2,iterations,1);
        System.out.println("\nEquation: x^3 + 2x^2 + 10x - 20, false position");
        falsePosition(1,2, iterations, 1);

        System.out.println("\nKashi Approximation for sin(3)");
        Kashi(0.5 * Math.pow(10, -17));
    }
}
