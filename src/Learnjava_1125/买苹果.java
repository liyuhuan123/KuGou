package Learnjava_1125;

import java.util.Scanner;

public class 买苹果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(helper(n));
        }
    }
    private static int helper(int n){
        if(n <= 10){
            if(n == 6){
                return 1;
            }else if(n == 8){
                return 1;
            }else{
                return -1;
            }
        }
        if(n % 2 != 0){
            return -1;
        }
        if(n % 8 == 0){
            return n / 8;
        }
        return 1 + n / 8;

    }
}
