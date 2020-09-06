package Learnjava_0906;

import java.util.Scanner;
//混合颜料--网易
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            helper(n,arr);
        }
    }
    private static void helper(int n,int[] arr){
        //选择排序
        for(int i = 0;i < n - 1;i++){
            for(int j = 0;j < n - 1;j++){
                if(arr[j] < arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for(int i = 0;i < n - 1;i++){
            for(int j = i + 1;j < n;j++){
                if((arr[i] ^ arr[j]) < arr[j]){
                    arr[j] = arr[j] ^ arr[i];
                }
            }
        }
        int count = 0;
        for(int i = 0;i < n;i++){
            if(arr[i] != 0){
                count++;
            }
        }
        System.out.println(count);
    }
}
