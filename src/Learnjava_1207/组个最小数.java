package Learnjava_1207;

import java.util.Scanner;

public class 组个最小数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] arr = new int[10];
            for(int i = 0;i < arr.length;i++){
                arr[i] = sc.nextInt();
            }
            helper(arr);
        }
    }
    private static void helper(int[] arr){
        StringBuffer result = new StringBuffer();
        for(int i = 1;i < 10;i++){
           if(arr[i] != 0){
                result.append(i);
                arr[i]--;
                break;
            }
        }
        for(int i = 0;i < 10;i++){
            while(arr[i] > 0){
                result.append(i);
                arr[i]--;
            }
        }
        System.out.println(result);

    }
}
