package Learnjava_1126;

import java.util.Scanner;

public class 神奇的口袋 {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i< n;i++){
                arr[i] = sc.nextInt();
            }
            helper(n,arr,0,0);
            System.out.println(count);
        }
    }
    private static void helper(int n,int[] arr,int index,int sum){
        if(sum == 40){
            count++;
            return;
        }else if(sum > 40){
            return;
        }
        if(index == n){
            return;
        }
        helper(n,arr,index+1,sum + arr[index]);
        helper(n,arr,index+1,sum);
    }
}
