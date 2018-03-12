public class RNG {
    public static double[] RNG(int n) {
        long[] l = new long[n + 1];
        double[] x = new double[n + 1];

        l[0] = System.nanoTime();

        for (int i = 1; i <= n; i++) {
            l[i] = (long)((Math.pow(7,5) * l[i - 1]) % (Math.pow(2,31) - 1));
            x[i] = l[i] / (Math.pow(2,31) - 1);
        }
        return x;
    }

    public static void main(String[] args) {
        double[] x = RNG(1000);

        for (int i = 1; i < 1001; i += 50) {
            System.out.println(x[i]);
            if (i == 1) {
                i -= 1;
            }
        }
    }
}
