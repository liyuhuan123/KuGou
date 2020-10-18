package Learnjava_1018;

import java.util.Arrays;

public class Sort {
    private static void insertSort(int[] arr){
        for(int i = 0;i < arr.length - 1;i++){
            int cur = arr[i + 1];
            int j = i;
            for(;j >= 0;j--){
                if(cur < arr[j]){
                    arr[j + 1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j + 1] = cur;
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void selectSort(int[] arr){
        for(int i = 0;i < arr.length - 1;i++){
            int maxIndex = 0;
            for(int j = 0;j < arr.length - i;j++){
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }
            swap(arr,maxIndex,arr.length - i - 1);
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void selectSort_High(int[] arr){
        for(int i = 0;i < arr.length - 1;i++){
            int minIndex = 0;
            int maxIndex = 0;
            for(int j = i;j < arr.length - 1- i;j++){
//                if(arr[j] > )
            }
        }
    }
    private static void bubbleSort(int[] arr){
        //方法1
//        for(int i = 0;i < arr.length - 1;i++){
//            boolean isSort = true;
//            for(int j = 0;j < arr.length - i - 1;j++){
//                if(arr[j] > arr[j + 1]){
//                    swap(arr,j,j + 1);
//                    isSort = false;
//                }
//            }
//            if(isSort){
//                break;
//            }
//
//
        //方法2
        for(int i = 0;i < arr.length;i++){
            for(int j = arr.length - 1;j > i;j--){
                if(arr[i] > arr[j]){
                    swap(arr,i,j);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //只能建大堆
    //时间复杂度
    //最好/平均/最坏：

    private static void heapSort(int[] arr){
        //1.建大堆
        createHeap(arr,arr.length);
        //2.进行选择的过程，一共需要arr.length-1组
        for(int i = 0;i < arr.length -1;i++){
            //无序[0,arr.length - i]
            swap(arr,0,arr.length - i - 1);
            //无序[0,arr.length - i - 1]
            adjustDown(arr,arr.length - i - 1,0);

        }
        System.out.println(Arrays.toString(arr));
    }

    private static void adjustDown(int[] arr,int size, int index) {
        while(2 * index + 1 < size) {
            int maxIndex = 2 * index + 1;
            if (maxIndex + 1 < size && arr[maxIndex + 1] > arr[maxIndex]) {
                maxIndex++;
            }
            if(arr[index] >= arr[maxIndex]){
                break;
            }
            swap(arr, index, maxIndex);
            index = maxIndex;
        }
        }

    private static void createHeap(int[] arr, int size) {
        for(int i = (size - 2) / 2;i >= 0;i--){
            adjustDown(arr,size,i);
        }
    }
//插排的优化版---分组插排
    private static void shellSort(int[] arr){
        int gap = arr.length;
        while(gap > 1){
            shellSort_helper(arr,gap);
            gap /= 2;
        }
        shellSort_helper(arr,1);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort_helper(int[] arr, int gap) {
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

    public static void main(String[] args) {
        int[] arr = {9,5,2,3,7,6,8};
        //insertSort(arr);
        //bubbleSort(arr);
        //heapSort(arr);
        shellSort(arr);
    }
}
