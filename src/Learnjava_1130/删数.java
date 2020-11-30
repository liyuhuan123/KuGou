package Learnjava_1130;

import java.util.Scanner;

public class 删数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(helper(n));
        }
    }
    private static int helper(int n){
        if(n > 1000){
            n = 999;
        }
        int result = 0;
        for(int i = 2;i <= n;i++){
            result = (result + 3) % i;
        }
        return result;
    }
}
