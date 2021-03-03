package Learnjava_21_0303;

import java.util.Arrays;

public class main {
    public static void heapSort(int[] arr){
        creatHeap(arr);
        for(int i = 0;i < arr.length - 1;i++){
            swap(arr,0,arr.length - 1 - i);
            shiftDown(arr,0,arr.length - 1 - i);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void creatHeap(int[] arr){
        for(int i = (arr.length - 1 - 1) / 2;i >= 0;i--){
            shiftDown(arr,i,arr.length);
        }
    }
    public static void shiftDown(int[] arr,int index,int heapLength){
        int parent = index;
        int child = parent * 2 + 1;
        while(child < heapLength){
            if(child + 1 < heapLength && arr[child] < arr[child + 1]){
                child += 1;
            }
            if(arr[child] > arr[parent]){
                swap(arr,child,parent);
            }else{
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
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
        int low = left;
        int high = mid;
        while(low < mid && high < right){
            if(arr[low] <= arr[high]){
                output[outputIndex++] = arr[low];
                low++;
            }else{
                output[outputIndex++] = arr[high];
                high++;
            }
        }
        while(low < mid){
            output[outputIndex++] = arr[low];
            low++;
        }
        while(high < right){
            output[outputIndex++] = arr[high];
            high++;
        }
        for(int i = 0;i < right - left;i++){
            arr[left + i] = output[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8,4,2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
