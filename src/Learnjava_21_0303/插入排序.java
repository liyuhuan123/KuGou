package Learnjava_21_0303;

import java.util.Arrays;

public class 插入排序 {
    public static void insertSort(int[] arr){
        for(int i = 1;i < arr.length;i++){
            int value = arr[i];
            int j = i - 1;
            for(;j >= 0;j--){
                if(arr[j] > value){
                    arr[j + 1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8,4,2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
