package Learnjava_0601;

import java.util.Scanner;

public class Finder {
    public int findKth(int[] a, int n, int K) {
        quickSortHelper(a,0,n - 1);
        return a[K - 1];
    }
    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right){
            return;
        }
        int index = method(array,left,right);
        quickSortHelper(array,0,index - 1);
        quickSortHelper(array,index + 1,right);

    }
    private static int method(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[right];
        while(i < j){
            while(i < j && base >= array[i]){
                i++;
            }
            while(i < j && base <= array[j]){
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

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,2};
        Finder finder = new Finder();
        finder.findKth(arr,5,3);
        System.out.println(finder.findKth(arr,5,3));

    }
}
