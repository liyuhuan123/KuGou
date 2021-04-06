package Learnjava_21_0406;

import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length;i++){
            for(int j = arr.length - 1;j > i;j--){
                if(arr[j] < arr[j - 1]){
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
