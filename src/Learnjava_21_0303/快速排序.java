package Learnjava_21_0303;

import java.util.Arrays;

public class 快速排序 {
    public static void quickSort(int[] arr){
        quickSortHelper(arr,0,arr.length - 1);
    }
    public static void quickSortHelper(int[] arr,int left,int right){
        if(right - left <= 0){
            return;
        }
        int index = method(arr,left,right);
        quickSortHelper(arr,left,index - 1);
        quickSortHelper(arr,index + 1,right);
    }
    public static int method(int[] arr,int left,int right){
        int low = left;
        int high = right;
        int baseNum = arr[right];
        while(low < high){
            while(low < high && arr[low] <= baseNum){
                low++;
            }
            while(low < high && arr[high] >= baseNum){
                high--;
            }
            swap(arr,low,high);
        }
        swap(arr,low,right);
        return low;
    }
    public static void swap(int[] arr,int left,int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8,4,2};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
