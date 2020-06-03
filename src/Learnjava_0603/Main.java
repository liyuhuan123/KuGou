package Learnjava_0603;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n == 0 || n == 1){
                return;
            }
            int b = 0;
            int c = 0;
            int sum = 0;
            do{
                b = n / 3;
                c = n % 3;
                n = b + c;
                sum = sum + b;
            }while(b != 0);
            if(n == 2){
                sum += 1;
            }
            System.out.println(sum);
        }
    }
}
