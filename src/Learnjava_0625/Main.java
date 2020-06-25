package Learnjava_0625;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //数列的和
        while(sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            double result = 0;
            int i = 1;
            double x = n;
            while(i <= k){
                result += x;
                x = Math.sqrt(x);
                i++;
            }
            System.out.println(String.format("%.2f",result));
        }
    }
}
