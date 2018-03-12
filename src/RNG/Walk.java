import java.util.Random;

public class Walk {
    public static void main(String[] args) {
        int n = 1000000;
        int k = 50;
        int r,d;
        int x = 0;
        int y = 0;
        int c = 0;
        Random rng = new Random();
        double p;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                r = rng.nextInt(4);
                if (r == 0) {
                    x++;
                } else if (r == 1) {
                    y++;
                } else if (r == 2) {
                    x--;
                } else if (r == 3) {
                    y--;
                } else {
                    System.out.println(r);
                }
            }
            d = Math.abs(x) + Math.abs(y);

            if (d > 20) {
                c++;
            }
            x = 0;
            y = 0;
        }
        p = (double)c/n;
        System.out.println("Probability: " + p);
    }
}
