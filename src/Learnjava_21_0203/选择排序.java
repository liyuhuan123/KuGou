package Learnjava_21_0203;

import java.util.Arrays;

public class 选择排序 {
    private static void selectSort(int[] array){
        for (int i = 0; i < array.length -1; i++) {
            for (int j = i + 1; j < array.length;j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
