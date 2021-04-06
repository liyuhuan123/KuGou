package Learnjava_21_0406;

import java.util.Arrays;

public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] arr) {
        //1.堆排序
        createHeap(arr);
        for(int i = 0;i < arr.length - 1;i++){
            int heapSize = arr.length - i;
            swap(arr,0,heapSize - 1);
            heapSize--;
            shiftDown(arr,heapSize,0);
        }
    }
    public static void createHeap(int[] arr){
        for(int i = (arr.length - 1 - 1) / 2;i >= 0;i--){
            shiftDown(arr,arr.length,i);
        }
    }
    public static void shiftDown(int[] arr,int heapSize,int index){
        int parent = index;
        int child = 2 * parent + 1;
        while(child < heapSize){
            if(child + 1 < heapSize && arr[child] < arr[child + 1]){
                child = child + 1;
            }
            if(arr[child] > arr[parent]){
                swap(arr,child,parent);
            }else{
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }

    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
