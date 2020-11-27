package Learnjava_1127;

import java.util.Scanner;

public class 计算糖果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int w = sc.nextInt();
            int A = (x + z) / 2;
            int B = A - x;
            int C = B - y;
            if(B + C == w){
                System.out.println(A+" "+B+" "+C);
            }else{
                System.out.println("No");
            }
        }
    }
}
