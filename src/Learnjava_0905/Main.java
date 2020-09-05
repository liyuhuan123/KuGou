package Learnjava_0905;

import java.util.Scanner;

public class Main {
    //Fibonacci数列---网易
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();

            System.out.println(helper(N));
        }
    }

    private static int helper(int n) {
        if(n < 4){
            return 0;
        }
        int x = 0;
        int y = 1;
        int sum = x + y;
        while((x + y) < n){
            sum = x + y;
            x = y;
            y = sum;
        }
        sum = x + y;
        return Math.min(sum - n,n - y);
    }
}
