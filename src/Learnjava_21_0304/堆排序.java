package Learnjava_21_0304;

import java.util.Arrays;

public class 堆排序 {
    public static void heapSort(int[] arr){
        //先建堆
        createHeap(arr);
        for(int i = 0;i < arr.length - 1;i++){
            swap(arr,arr.length - 1 - i,0);
            shiftDown(arr,arr.length - 1 - i,0);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void createHeap(int[] arr){
        for(int i = (arr.length - 1 - 1) / 2;i >= 0;i--){
            shiftDown(arr,arr.length,i);
        }
    }
    public static void shiftDown(int[] arr,int heapLength,int index){
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
            child = parent * 2 + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8,2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
