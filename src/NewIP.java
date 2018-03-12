public class NewIP {
    public static double f(double x) {
        return Math.sin(x);
    }

    public static double g(double x) {
        return Math.pow((Math.pow(x,2) + 1), -1);
    }

    public static double[] coef(double[] x, double[] y) {
        double[] a = new double[x.length];

        for (int i = 0; i < a.length; i++) {
            a[i] = y[i];
        }

        for (int j = 1; j < a.length; j++) {
            for (int i = a.length; i < j; i--) {
                a[i] = (a[i] - a[i-1])/(x[i] - x[i-j]);
            }
        }

        return a;
    }

    public static double eval(double[] x, double[] a, double t) {
        double temp = a[a.length - 1];

        for (int i = a.length - 1; i > 0; i--) {
            temp = (temp) * (t - x[i]) + a[i];
        }

        return temp;
    }

    public static void main(String[] args) {
        int j, k, n, jmax;
        double e, h, p, t, emax, pmax, tmax;
        pmax = 0;
        tmax = 0;
        jmax = 0;
        double[] x, y, a;
        n = 9;
        x = new double[n];
        y = new double[n];
        h = 1.6875/n;

        for (k = 0; k < n; k++) {
            x[k] = k*h;
            y[k] = f(x[k]);
        }

        a = coef(x, y);
        emax = 0;

        System.out.println("Example 8: sin(1.6875)");
        System.out.printf("|  j  |       t       |       p       |       e       |%n");
        for (j = 0; j < 4*n; j++) {
            t = (j*h) / 4;
            p = eval(x, a, t);
            e = Math.abs(Math.sin(t) - p);

            System.out.printf("| %3d | %1.11f | %1.11f | %1.11f |%n", j, t, p, e);

            if (e > emax) {
                jmax = j;
                tmax = t;
                pmax = p;
                emax = e;
            }
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("| jmax|     tmax      |     pmax      |     emax      |%n");
        System.out.printf("| %3d | %1.11f | %1.11f | %1.11f |%n", jmax, tmax, pmax, emax);

        n = 20;
        x = new double[n];
        y = new double[n];
        h = 10.0/n;

        for (k = 0; k < n; k++) {
            x[k] = (k*h) - 5;
            y[k] = g(x[k]);
        }

        a = coef(x, y);
        emax = 0;

        System.out.println("\n4.2 Problem 1: f(x) = (x^2 + 1)^-1, [-5,5]");
        System.out.printf("|  j  |       t       |            p            |            e            |%n");
        for (j = 0; j < 2*n; j++) {
            t = ((j*h) / 2) - 5;
            p = eval(x, a, t);
            e = Math.abs(Math.pow((Math.pow(t,2) + 1), -1) - p);

            System.out.printf("| %3d | % .10f | %23.11f | %23.11f |%n", j, t, p, e);

            if (e > emax) {
                jmax = j;
                tmax = t;
                pmax = p;
                emax = e;
            }
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("| jmax|     tmax      |          pmax           |          emax           |%n");
        System.out.printf("| %3d | %1.11f | %1.11f | %1.11f |%n", jmax, tmax, pmax, emax);

    }
}
