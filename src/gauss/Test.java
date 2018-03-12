import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] arr = {3,4,1,2,7,8,5,9,6,0};
        boolean sorted = false;
        boolean trigger = false;

        System.out.println(Arrays.toString(arr));

        while (sorted == false) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i+1]){
                    int val = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = val;
                    trigger = true;
                }
            }


            if (trigger == false)
                sorted = true;

            trigger = false;
        }

        System.out.println(Arrays.toString(arr));
    }
}
