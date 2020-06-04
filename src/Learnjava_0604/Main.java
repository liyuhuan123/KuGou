package Learnjava_0604;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(need(n));
        }
    }

    private static int need(int n) {
        if(n < 6 || n % 2 != 0 || n == 10){
            return -1;
        }
        int chu = n / 8;
        int yu = n % 8;
        int temp = 0;
        if(yu == 0){
            return chu;
        }else {
            temp++;
            return chu + 1;
        }
    }
}
