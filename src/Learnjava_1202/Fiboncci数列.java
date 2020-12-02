package Learnjava_1202;

import java.util.Scanner;

public class Fiboncci数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            System.out.println(helper(x));
        }
    }
    private static int helper(int x){
        int temp1 = 0;
        int temp2 = 0;
        int cur = 0;
        int f0 = 0;
        int f1 = 1;
        while(true){
            cur = f0 + f1;
            f0 = f1;
            f1 = cur;
            if(cur < x){
                temp1 = x - cur;
            }else{
                temp2 = cur - x;
                break;
            }
        }
        return temp1 > temp2 ? temp2 : temp1;
    }
}
