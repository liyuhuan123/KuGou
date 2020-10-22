package Learnjava_1022;

import java.util.Arrays;

//七大排序算法练习
public class Sort {
    //1.插入排序
    private static void insertSort(int[] arr){
        for(int i = 1;i < arr.length;i++){
            int cur = arr[i];
            int j = i - 1;
            for(;j >= 0;j--){
                if(arr[j] > cur){
                    arr[j + 1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j + 1] = cur;
        }
    }
    //2.希尔排序
    private static void shellSort(int[] arr){
        int gap = arr.length;
        while(gap > 1){
            shellSort_Helper(arr,gap);
            gap /= 1;
        }
        shellSort_Helper(arr,1);
    }
    private static void shellSort_Helper(int[] arr,int gap){
        for(int i = gap;i < arr.length;i++){
            int cur = arr[i];
            int j = i - gap;
            for(;j >= 0;j -= gap){
                if(arr[j] > cur){
                    arr[j + gap] = arr[j];
                }else{
                    break;
                }
            }
            arr[j + gap] = cur;
        }
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //3.冒泡排序
    private static void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = 0;j < arr.length - 1 - i;j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,j + 1);
                }
            }
        }
    }
    //4.选择排序
    private static void selectSort(int[] arr){
        for(int i = 0;i < arr.length - 1;i++){
            int maxIndex = 0;
            for(int j = 1;j < arr.length - i - 1;j++){
                if(arr[maxIndex] <  arr[j]){
                    maxIndex = j;
                }
            }
            swap(arr,maxIndex,arr.length - i - 1);
        }
    }
    //5.快速排序
    private static void quickSort(int[] arr){
        quickSort_Helper(arr,0,arr.length - 1);
    }
    private static void quickSort_Helper(int[] arr,int left,int right){
        if(left - right <= 0){
            return;
        }
        int index = partition(arr,left,right);
        quickSort_Helper(arr,left,index - 1);
        quickSort_Helper(arr,index + 1,right);
    }
    private static int partition(int[] arr,int left,int right){
        int baseNum = arr[right];
        int low = left;
        int high = right;
        while(low < high){
            while(low < high && arr[low] <= arr[high]){
                low++;
            }
            while(low < high && arr[high] >= arr[low]){
                high--;
            }
            swap(arr,low,high);
        }
        swap(arr,low,right);
        return low;
    }
    //6.归并排序
    private static void mergeSort(int[] arr){
        mergeSort_Helper(arr,0,arr.length);
    }
    private static void mergeSort_Helper(int[] arr,int left,int right){
        if(right - left <= 1){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort_Helper(arr,left,mid);
        mergeSort_Helper(arr,mid,right);
        merge(arr,left,mid,right);
    }
    private static void merge(int[] arr,int left,int mid,int right){
        int[] output = new int[right - left];
        int outputIndex = 0;
        int low = left;
        int high = right;
        while(low < mid && mid < high){
            if(arr[low] <= arr[high]){
                output[outputIndex] = arr[low];
                outputIndex++;
                low++;
            }else{
                output[outputIndex] = arr[high];
                outputIndex++;
                high++;
            }
        }
        while(low < mid){
            output[outputIndex] = arr[low];
            outputIndex++;
            low++;
        }
        while(high < right){
            output[outputIndex] = arr[high];
            outputIndex++;
            high++;
        }
        for(int i = 0;i < high - low;i++){
            arr[left + 1] = output[i];
        }
    }
    //7.堆排序
    private static void heapSort(int[] arr) {
        createHeap(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            swap(arr, 0, arr.length - i - 1);
            shiftDown(arr, arr.length - i - 1, 0);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void createHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            shiftDown(arr, arr.length, i);
        }
    }

    private static void shiftDown(int[] arr, int size, int index) {
        int left = 2 * index + 1;
        while (left < size) {
            int max = left;
            int right = left + 1;
            if (right < size) {
                if (arr[right] > arr[left]) {
                    max = right;
                }
            }
            if (arr[index] >= arr[max]) {
                break;
            }
            swap(arr, index, max);
            index = max;
            left = 2 * index + 1;
        }
    }
    public static void main(String[] args) {
        int[] arr = {9,5,2,3,7,6,8};
        //insertSort(arr);
        //shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
