import java.util.Random;

public class Pi {
    public static void main(String[] args) {
        double start    = -1;
        double end      =  1;
        double x,y,r;
        int count = 0;
        int n = 4000000;
        for (int i = 0; i < n; i++) {
            x = new Random().nextDouble();
            y = new Random().nextDouble();

            x = start + (x * (end - start));
            y = start + (y * (end - start));

            r = Math.pow(x,2) + Math.pow(y,2);

            if (r <= 1) {
                count++;
            }
        }

        double pi = (double)(4*count) / n;
        System.out.println(pi);
    }
}
