package Learnjava_0506;

import java.util.Arrays;
import java.util.Stack;
public class review_Sort {
    private static void quickSort(int[] array){
        quickSortHelper(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right){
            return;
        }
        int index = partition(array,left,right);
        quickSortHelper(array,0,index - 1);
        quickSortHelper(array,index + 1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[right];
        while(i < j){
            while(i < j && array[i] <= base){
                i++;
            }
            while(i < j && array[i] >= base){
                j--;
            }
            swap(array,i,j);
        }
        swap(array,i,right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private static void quickSortByLoop(int[] array){
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);
        while(!stack.isEmpty()){
            int left = stack.pop();
            int right = stack.pop();
            if(left >= right){
                return;
            }
            int index = partition(array,left,right);
            stack.push(right);
            stack.push(index + 1);
            stack.push(index - 1);
            stack.push(left);
        }
    }
    private static void mergeSort(int[] array){
        mergeSortHelper(array,0,array.length);
    }

    private static void mergeSortHelper(int[] array, int low, int high) {
        if(high - low <= 1){
            return;
        }
        int mid = (high + low) / 2;
        mergeSortHelper(array,low,mid);
        mergeSortHelper(array,mid,high);
        merge(array,low,mid,high);
    }
    private static void merge(int[] array,int low,int mid,int high){
        int[] output = new int[high - low];
        int outputindex = 0;
        int cur1 = low;
        int cur2 = mid;
        while(cur1 < cur2 && cur2 < high){
            if(array[cur1] <= array[cur2]){
                output[outputindex] = array[cur1];
                outputindex++;
                cur1++;
            }else{
                output[outputindex] = array[cur2];
                outputindex++;
                cur2++;
            }
        }
        while(cur1 < mid){
            output[outputindex] = cur1;
            outputindex++;
            cur1++;
        }
        while(cur2 < high){
            output[outputindex] = cur2;
            outputindex++;
            cur2++;
        }
        for(int i = 0;i < high - low;i++){
            array[low + 1] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
//        quickSortByLoop(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
