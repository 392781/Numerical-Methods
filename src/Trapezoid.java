public class Trapezoid {
    public static double f(double x, int f) {
        if (f == 0) {
            return Math.sin(x);
        } else if (f == 1) {
            return Math.exp(x);
        } else if (f == 2) {
            return Math.atan(x);
        } else if (f == 3) {
            return (x - (Math.pow(x,3)/18) + (Math.pow(x,5)/600) - (Math.pow(x,7)/35280));
        } else {
            return 0;
        }
    }

    public static double integrate(int f, double a, double b, int n) {
        double h = (b - a) / n;
        double x;
        double sum = 0.5 * (f(a,f) + f(b,f));

        for (int i = 1; i < n - 1; i++) {
            x = a + (i*h);
            sum = sum + f(x,f);
        }

        sum = sum * h;

        return sum;
    }

    public static void main(String[] args) {
        int n = 60;
        System.out.println("Trapezoid Rule Integration");
        System.out.printf("  n = %-4d | %10s | %10s | %10s | %n" +
                        "%10s | %10f | %10f | %10f | %n" +
                        "%10s | %10s | %10s | %10s | %n%n",
                        n, "sin(x)", "e^x", "arctan(x)",
                        "Trapezoid:",
                        integrate(0,0,Math.PI, n),
                        integrate(1,0,1, n),
                        integrate(2,0,1, n),
                        "Exact:", "2", "1.718281","0.438824");

        n = 800;
        System.out.printf("  n = %-4d | %13s | %n" +
                        "%10s | %13f | %n" +
                        "%10s | %13s | %n%n",
                        n, "x^-1 * sin(x)",
                        "Trapezoid:",
                        integrate(3,0,1,n),
                        "Exact:",
                        "0.946083");
    }
}
