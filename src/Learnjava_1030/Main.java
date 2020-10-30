package Learnjava_1030;

import java.util.Scanner;

public class Main {
    //1.求质数
    //给定n <= 100个整数，请你求出所有的质数之和
    //输入
    //第一行 一个正整数n
    //第二行n个数字
    //输出
    //一行n个数中所有的质数之和
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int sum = 0;
            for(int i = 0;i < n;i++){
                int temp = sc.nextInt();
                if(zhishu(temp)){
                    sum += temp;
                }
            }
            System.out.println(sum);
        }
    }
    private static boolean zhishu(int x){
        if(x <= 1){
            return false;
        }
        if(x == 2){
            return true;
        }
        for(int i = 2;i <= Math.sqrt(x);i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
}
