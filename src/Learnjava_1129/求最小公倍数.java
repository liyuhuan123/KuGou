package Learnjava_1129;

import java.util.Scanner;

public class 求最小公倍数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(helper(x,y));
        }
    }
    private static int helper(int x,int y){
        if(x > y){
            int temp = x;
            x = y;
            y = temp;
        }
        if(y % x == 0){
            return y / x;
        }
        int z = x;
        while(true){
            if(z % x == 0 && z % y == 0){
                return z;
            }
            z++;
        }
    }
}
