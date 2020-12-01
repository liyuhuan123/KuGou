package Learnjava_1201;

import java.util.Scanner;

public class 数字颠倒 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            System.out.println(helper(x));
        }
    }
    private static String helper(int x){
        StringBuffer result = new StringBuffer();
        if(x == 0){
            return String.valueOf(0);
        }
        while(x > 0){
            int temp = x % 10;
            result.append(temp);
            x /= 10;
        }
        return String.valueOf(result);
    }
}
