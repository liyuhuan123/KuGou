package Learnjava_21_0406;

import java.util.Arrays;

public class 希尔排序 {
    public static void main(String[] args) {
            int[] arr = {9,5,2,7,3,6,8};
            shellSort(arr);
            System.out.println(Arrays.toString(arr));
        }
    public static void shellSort(int[] arr){
        int gap = arr.length / 2;
        while(gap >= 1){
            shellsortHelper(arr,gap);
            gap = gap / 2;
        }
    }
    public static void shellsortHelper(int[] arr,int gap){
        for(int i = gap;i < arr.length;i++){
            int v = arr[i];
            int j = i - gap;
            for(;j >= 0;j -= gap){
                if(arr[j] > v){
                    arr[j + gap] = arr[j];
                }else{
                    break;
                }
            }
            arr[j + gap] = v;
        }
    }
}
