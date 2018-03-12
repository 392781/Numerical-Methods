public class Gauss {
    public static double[][] gEliminate(double[][] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                arr[j][i] = arr[j][i]/arr[i][i];
                for (int k = j + 1; j < arr[j].length; k++) {
                    arr[j][k] = arr[j][k] - (arr[j][i]*arr[i][k]);
                }
            }
        }

        return arr;
    }



    public static void backSub(double[] arr) {

    }

    public static void main(String[] args) {
        double[][] arr = {{1,   2,  3,  4}
                        , {5,   6,  7,  8}
                        , {9,  10, 11, 12}};

        arr = gEliminate(arr);

        System.out.println(arr);
    }
}
