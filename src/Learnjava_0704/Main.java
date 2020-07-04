package Learnjava_0704;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //大整数排序
        while(sc.hasNext()){
            int n = sc.nextInt();
            BigInteger[] nums = new BigInteger[n];
            for(int i = 0;i < n;i++){
                nums[i] = sc.nextBigInteger();
            }
            Arrays.sort(nums);
            for(int i = 0;i < n;i++){
                System.out.println(nums[i]);
            }
        }
    }
}
