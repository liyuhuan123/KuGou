package Learnjava_0630;

import java.util.Scanner;

public class Main {
    //数字之和
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int N = n * n;
            int sum1 = 0;
            int sum2 = 0;
            while(n != 0){
                sum1 += n % 10;
                n /= 10;
            }
            while(N != 0){
                sum2 += N % 10;
                N /= 10;
            }
            System.out.println(sum1 + " " + sum2);
        }
    }
}
