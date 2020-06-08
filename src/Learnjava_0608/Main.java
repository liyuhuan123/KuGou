package Learnjava_0608;

import java.util.Scanner;
//求两个数的最小公倍数（辗转相除法）
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a < b){
                int temp = a;
                a = b;
                b = temp;
            }
            int m = a * b;
            int c = a % b;
            while(c != 0){
                a = b;
                b = c;
                c = a % b;
            }
            System.out.println(m / b);
        }
    }
}
