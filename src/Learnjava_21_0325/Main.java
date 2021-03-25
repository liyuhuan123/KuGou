package Learnjava_21_0325;

import java.util.Scanner;

//[1,3,4,12,8]
//2
//[4,12,8,1,3]
public class Main {
    public static void helper(int k){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        if(k >= length){
            k = k % length;
        }
        int[] array = new int[length];
        //整体倒序
        for(int i = length - 1;i >= 0;i--){
            array[i] = sc.nextInt();
        }
        //前length - k个元素倒序
        for(int i = 0,j = length - k - 1;i <= j;j--){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        //后k个元素倒序
        for(int i = length - k,j = length - 1;i <= j;i++,j--){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        for(int i = 0;i < array.length;i++){
            System.out.print(array[i]);
        }
    }

    public static void main(String[] args) {
        helper(4);
    }
}
