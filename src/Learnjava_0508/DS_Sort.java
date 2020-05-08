package Learnjava_0508;

import java.util.Arrays;
import java.util.Stack;

public class DS_Sort {
    private static void quickSort(int[] array){
        quickSortHelper(array,0,array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right){
            return;
        }
        int index = method(array,0,right);
        quickSortHelper(array,0,index - 1);
        quickSortHelper(array,index + 1,right);

    }
    private static int method(int[] array,int left,int right){
        int i = left;
        int j = right;
        int base = array[right];
        while(i < j){
            while(i < j && array[i] <= base){
                i++;
            }
            while(i < j && array[j] >= base){
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
        Stack<Integer> stack= new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);
        while(!stack.isEmpty()){
            int left = stack.pop();
            int right = stack.pop();
            if(left >= right){
                continue;
            }
            int index = method(array,left,right);
            stack.push(right);
            stack.push(index + 1);
            stack.push(index - 1);
            stack.push(left);
        }
    }
    private static void mergeSort(int[] array){
        mergeSortHelper(array,0,array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        if(right - left <= 1){
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper(array,left,mid);
        mergeSortHelper(array,mid,right);
        merge(array,left,mid,right);
    }
    private static void merge(int[] array,int left,int mid,int right){
        int[] output = new int[right - left];
        int outputindex = 0;
        int cur1 = left;
        int cur2 = mid;
        while(cur1 < mid && cur2 < right){
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
            output[outputindex] = array[cur1];
            cur1++;
            outputindex++;
        }
        while(cur2 < right){
            output[outputindex] = array[cur2];
            cur2++;
            outputindex++;
        }
        for(int i = 0;i < right - left;i++){
            array[left + 1] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
//        quickSort(array);
//        quickSortByLoop(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
