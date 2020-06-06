package Learnjava_0606;

import java.util.Scanner;

public class Main {
    //计算糖果
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            int A = (m + j) / 2;
            int B = (n + k) / 2;
            int C = k - B;
            if((m == A - B) && (n == B - C) && (j == A + B) && (k == B + C)){
                System.out.println(A + " " + B + " " + C);
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
