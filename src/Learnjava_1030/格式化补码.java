package Learnjava_1030;

import java.util.Arrays;
import java.util.Scanner;

public class 格式化补码 {
    //给定一个整数x，请你输出它在计算机中的补码（32位），输出的时候每思维之间加一个字符‘-’
    //便于区分
    //输入
    //第一行一个整数x
    //一行计算机中的补码（32位)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] bit = new int[32];
            for(int i = 31;i >= 0;i--){
                if(((1 << i) & n) != 0){
                    bit[i] = 1;
                    i++;
                }else{
                    bit[i] = 0;
                }
            }
            System.out.println(Arrays.toString(bit));
            for(int i = 31;i >= 0;i--){
                System.out.print(bit[i]);
                if(i != 0 && i != 31 && i % 4 == 0){
                    System.out.print("-");
                }
            }
        }
    }
}
