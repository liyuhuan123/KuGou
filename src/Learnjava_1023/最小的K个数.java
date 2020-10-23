package Learnjava_1023;

import java.util.Arrays;

public class 最小的K个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        for(int i = 0;i < k;i++){
            result[i] = arr[i];
        }
        return result;
    }
}
