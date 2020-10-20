package Learnjava_1020;

import java.util.Arrays;
import java.util.Stack;

public class reviewSort {
    private static void insertSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            int cur = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (cur < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = cur;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = 0;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(arr, maxIndex, arr.length - i - 1);
        }
    }

    private static void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            shellSortHelper(arr, gap);
            gap /= 2;
        }
        shellSortHelper(arr, 1);
    }

    private static void shellSortHelper(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            int cur = arr[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (cur < arr[j]) {
                    arr[j + gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + gap] = cur;
        }
    }

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
    private static int partition(int[] arr,int left,int right){
        int low = left;
        int high = right;
        int baseNum = arr[high];
        while(low < high){
            while(low < high && arr[low] <= baseNum){
                low++;
            }
            while(low < high && arr[high] >= baseNum){
                right--;
            }
            swap(arr,low,high);
        }
        swap(arr,low,right);
        return left;
    }
    private static void quickSort(int[] arr){
        quickSortHelper(arr,0,arr.length - 1);
    }
    private static void quickSortHelper(int[] arr,int left,int right){
        if(right - left <= 0){
            return;
        }
        int index = partition(arr,left,right);
        partition(arr,0,index - 1);
        partition(arr,index + 1,right);
    }
    private static void quickSortByLoop(int[] arr){
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1);
        stack.push(0);
        while(!stack.isEmpty()){
            int left = stack.pop();
            int right = stack.pop();
            if(left >= right){
                continue;
            }
            int index = partition(arr,left,right);
            stack.push(right);
            stack.push(index + 1);
            stack.push(index - 1);
            stack.push(left);
        }
    }
    private static void merge(int[] arr,int low,int mid,int high){
        int[] output = new int[high - low];
        int outputIndex = 0;
        int cur1 = low;
        int cur2 = mid;
        while(cur1 < mid && cur2 < high){
            if(arr[cur1] < arr[cur2]){
                output[outputIndex] = arr[cur1];
                outputIndex++;
                cur1++;
            }else{
                output[outputIndex] = arr[cur2];
                outputIndex++;
                cur2++;
            }
        }
        while(cur1 < mid){
            output[outputIndex] = arr[cur1];
            outputIndex++;
            cur1++;
        }
        while(cur2 < high){
            output[outputIndex] = arr[cur2];
            outputIndex++;
            cur2++;
        }
        for(int i = 0;i < high - low;i++){
            arr[low + 1] = output[i];
        }
    }
    private static void mergeSort(int[] arr){
        mergeSortHelper(arr,0,arr.length);
    }
    private static void mergeSortHelper(int[] arr,int left,int right){
        if(right - left <= 0){
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper(arr,left,mid);
        mergeSortHelper(arr,mid,right);
        merge(arr,left,mid,right);
    }
    private static void mergeSortByLoop(int[] arr){
        for(int gap = 1;gap < arr.length;gap *= 2){
            for(int j = 0;j < arr.length;j += 2 * gap){
                int beg = j;
                int mid = j + gap;
                int end = j + 2 * gap;
                if(mid > arr.length){
                    mid = arr.length;
                }
                if(end > arr.length){
                    end = arr.length;
                }
                merge(arr,beg,mid,end);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {3,5,2,1,5,7,4,3};
        //quickSort(arr);
        quickSortByLoop(arr);
        System.out.println(Arrays.toString(arr));
    }
}
