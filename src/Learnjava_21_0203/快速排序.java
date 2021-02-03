package Learnjava_21_0203;

import java.util.Arrays;

public class 快速排序 {
    private static void quickSort(int[] arr){
        quickSortHelper(arr,0,arr.length - 1);
    }
    private static void quickSortHelper(int[] arr,int left,int right){
        if(right - left <= 0){
            return;
        }
        int index = method(arr,left,right);
        quickSortHelper(arr,left,index - 1);
        quickSortHelper(arr,index + 1,right);
    }
    private static int method(int[] arr,int left,int right){
        int start = left;
        int end = right;
        int baseNum = arr[right];
        while(start < end){
            while(start < end && arr[start] <= baseNum){
                start++;
            }
            while(start < end && arr[end] >= baseNum){
                end--;
            }
            swap(arr,start,end);
        }
        swap(arr,start,right);
        return start;
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
