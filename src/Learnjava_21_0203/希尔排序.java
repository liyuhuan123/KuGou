package Learnjava_21_0203;

import java.util.Arrays;

public class 希尔排序 {
    private static void shellSort(int[] arr){
        int length = arr.length;
        while(length > 1){
            shellSortHelper(arr,length);
            length /= 2;
        }
        shellSortHelper(arr,1);
    }
    private static void shellSortHelper(int[] arr,int gap){
        for(int i = gap;i < arr.length;i++){
            int value = arr[i];
            int j = i - gap;
            for(;j >= 0;j -= gap){
                if(arr[j] > value){
                    arr[j + gap] = arr[j];
                }else{
                    break;
                }
            }
            arr[j + gap] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
