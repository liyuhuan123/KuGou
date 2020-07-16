package Learnjava_0716;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //连续最大和
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(helper(arr,n));
        }
    }

    private static int helper(int[] arr, int n) {
        int count = Integer.MIN_VALUE;
        if(arr == null || n == 0){
            return 0;
        }
        if(n == 1){
            return arr[1];
        }
        int curCount = 0;
        for(int i = 0;i < n;i++){
            if(curCount <= 0){
                curCount = arr[i];
            }else{
                curCount += arr[i];
            }
            if(curCount > count){
                count = curCount;
            }
        }
        return count;

    }
}
