package Learnjava_21_0303;

import java.util.Arrays;

public class 希尔排序 {
    public static void shellSort(int[] arr){
        int gap = arr.length;
        while(gap > 1){
            shellSortHelper(gap,arr);
            gap /= 2;
        }
        shellSortHelper(1,arr);
    }
    public static void shellSortHelper(int gap,int[] arr){
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
        int[] arr = {9,5,2,7,3,6,8,4,2};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
