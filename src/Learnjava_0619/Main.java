package Learnjava_0619;

import java.util.Scanner;

public class Main {
    //洗牌
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();//T组
        while(T>0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] num1 = new int[n]; //接收前一半
            int[] num2 = new int[n];//接收后半
            for(int i = 0;i<n;i++){
                num1[i] = sc.nextInt();
            }
            for(int i = 0;i<n;i++){
                num2[i] = sc.nextInt();
            }
            int[] nums = new int[2*n];
            for(int i = 0;i<k;i++){
                fanZhuan(num1,num2,n,nums);
            }
            for(int i = 0;i<2*n;i++){
                if(i == 2*n-1){
                    System.out.print(nums[i]);
                }else{
                    System.out.print(nums[i]);
                    System.out.print(" ");
                }
            }
            T--;
            if(T > 0){
                System.out.println();
            }
        }

    }
    public static void fanZhuan(int[] num1,int[] num2,int n,int[] nums){
        for(int i = 0;i<n;i++){
            nums[2*i] = num1[i];
        }
        for(int i = 0;i<n;i++){
            nums[2*i +1] = num2[i];
        }
        for(int i = 0;i<2*n;i++){
            if(i<n){
                num1[i] = nums[i];
            }else{
                num2[i-n] = nums[i];
            }
        }
    }
}
