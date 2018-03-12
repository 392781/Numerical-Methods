public class LeastSqs {
    private static double p, q, r, s, d, a, b;

    public static void leastSquares(double[] x, double[] y) {
        p = 0;
        q = 0;
        r = 0;
        s = 0;
        for (double val : x) {
            p += val;
        }

        for (double val : y) {
            q += val;
        }

        for (int i = 0; i < x.length; i++) {
            r += (x[i] * y[i]);
        }

        for (double val : x) {
            s += Math.pow(val,2);
        }

        d = ((x.length) * s) - Math.pow(p,2);
        a = (((x.length) * r) - (p*q))/d;
        b = ((s*q) - (p*r))/d;

        System.out.println("y = ax + b\n" +
                "Value of 'a': " + a + "\n" +
                "Value of 'b': " + b + "\n");
    }

    public static void main(String[] args) {
        // Opening problem of chapter
        double[] T = { 0, 10  , 20  , 30  , 40  , 80  , 90, 95};
        double[] S = {68, 67.1, 66.4, 65.6, 64.6, 61.8, 61, 60};

        // Example 1
        double[] x = {4, 7, 11, 13, 17};
        double[] y = {2, 0, 2 ,  6,  7};

        System.out.println("Opening problem:");
        leastSquares(T,S);
        System.out.println("Example 1:");
        leastSquares(x,y);

    }
}
