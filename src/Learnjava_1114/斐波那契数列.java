package Learnjava_1114;

import java.util.Scanner;

public class 斐波那契数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(Fibonacci(n));
        }
    }

    private static int Fibonacci(int n) {
        int a = 0;
        int b = 1;
        while(n >= b){
            int temp = a;
            a = b;
            b = temp + b;
        }
        if(b - n < n - a){
            return b - n;
        }else{
            return n - a;
        }
    }
}
