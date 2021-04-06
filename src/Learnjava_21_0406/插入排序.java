package Learnjava_21_0406;

import java.util.Arrays;

public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {9,5,2,3,7,6,8};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr){
        for(int i = 1;i < arr.length;i++){
            int v = arr[i];
            int j = i - 1;
            for(;j >= 0;j--){
                if(arr[j] > v){
                    arr[j + 1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j + 1] = v;
        }
    }
}
