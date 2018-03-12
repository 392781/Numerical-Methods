public class CE1 {
    int m = 10;
    int i, j, n;

    float arrA[][] = new float[m][m];
    float arrB[] = new float[m];
    float arrX[] = new float[][m];

    for (n = 4; n <= 10; n++) {
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                arrA[i][j] = ((float)Math.pow((i + 1), j - 1));
            }
            arrB[i] = ((float) (Math.pow((i + 1), n) - 1)/i);
        }
        CE10.NaiveGauss(n, arrA, arrB, arrX);
    }
}
