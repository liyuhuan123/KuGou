package Learnjava_21_0406;

import java.util.Arrays;

public class 归并排序 {
    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr){
        mergeSortHelper(arr,0,arr.length);
    }
    public static void mergeSortHelper(int[] arr,int left,int right){
        if(right - left <= 1){
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper(arr,left,mid);
        mergeSortHelper(arr,mid,right);
        method(arr,left,mid,right);
    }
    public static void method(int[] arr,int left,int mid,int right){
        int[] output = new int[right - left];
        int outputIndex = 0;
        int cur1 = left;
        int cur2 = mid;
        while(cur1 < mid && cur2 < right){
            if(arr[cur1] <= arr[cur2]){
                output[outputIndex++] = arr[cur1++];
            }else{
                output[outputIndex++] = arr[cur2++];
            }
        }
        while(cur1 < mid){
            output[outputIndex++] = arr[cur1++];
        }
        while(cur2 < right){
            output[outputIndex++] = arr[cur2++];
        }
        for(int i = 0;i < outputIndex;i++){
            arr[left + i] = output[i];
        }
    }
}
