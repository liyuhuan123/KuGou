package Learnjava_21_0303;

import java.util.Arrays;

public class 冒泡排序 {
    public static void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length;i++){
            for(int j = arr.length - 1;j > i;j--){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8,4,2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
