package Learnjava_21_0304;

import java.util.Arrays;

public class 归并排序 {
    public static void mergeSort(int[] arr){
        mergeSortHelper(arr,0,arr.length);
    }
    public static void mergeSortHelper(int[] arr,int low,int high){
        if(high - low <= 1){
            return;
        }
        int mid = (low + high) / 2;
        mergeSortHelper(arr,low,mid);
        mergeSortHelper(arr,mid,high);
        method(arr,low,mid,high);
    }
    public static void method(int[] arr,int mid,int low,int high){
        int[] output = new int[high - low];
        int outputIndex = 0;
        int left = low;
        int right = mid;
        while(left < mid && right < high){
            if(arr[left] <= arr[right]){
                output[outputIndex++] = arr[left];
                left++;
            }else{
                output[outputIndex++] = arr[right];
                right++;
            }
        }
        while(left < mid){
            output[outputIndex++] = arr[left];
            left++;
        }
        while(right < high){
            output[outputIndex++] = arr[right];
            right++;
        }
        for(int i = 0;i < high - low;i++){
            arr[low + i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8,2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
