import java.util.*;

public class CE10 {
    static int i, j, k;
    static float xmult, sum;
    static float arrA[][] = {
            {15, -2, -6, 0 },
            {-2, 12, -4, -1},
            {-6, -4, 19, -9},
            { 0, -1, -9, 21}
    };

    static double arrB[] = {300, 0, 0, 0};

    public static void NaiveGauss(int n, float arrA[][], float arrB[], float arrX[]) {
        for (k = 0; k <= n; k++) {
            for (i = k + 1; i <= n; i = i + k + 1) {
                xmult = arrA[i][k]/arrA[k][k];
                arrA[i][k] = xmult;
                for(j = k + 1; j <= n; j = j + k + 1) {
                    arrA[i][j] = arrA[i][j] - (xmult * arrA[k][j]);
                }
                arrB[i] = arrB[i] - (xmult * arrB[k]);
            }
        }

        arrX[n] = arrB[n]/arrA[n][n];
        for(i = n - 1; i >= 0; i--) {
            sum = arrB[i];
            for(j = i + 1; j <= n; j = j + i + 1) {
                sum = sum - (arrA[i][j] * arrX[j]);
            }
            arrX[i] = sum/arrA[i][i];
        }

        System.out.println("n: " + n);
        System.out.println("arrX: " + arrX);
    }
}