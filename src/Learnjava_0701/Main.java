package Learnjava_0701;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //守形数
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            helper(N);
        }
    }

    private static void helper(int n) {
        int temp = n * n;
        if(n < 10){
            if((temp - n) % 10 == 0){
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }
        }else{
            if((temp - n) % 100 == 0){
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }
        }
    }
}
