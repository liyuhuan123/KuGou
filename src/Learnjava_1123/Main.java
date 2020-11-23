package Learnjava_1123;

import java.util.Scanner;
//汽水瓶
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n == 0){
                break;
            }
            i++;
            if(i >= 10){
                break;
            }
            System.out.println(helper(n));
        }
    }
    private static int helper(int n){
        int count = 0;
        while(n >= 3){
            int temp = n / 3;
            count += temp;
            n %= 3;
            n += temp;
        }
        if(n == 2){
            return count + 1;
        }
        return count;
    }
}