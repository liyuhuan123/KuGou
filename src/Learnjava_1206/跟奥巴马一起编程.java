package Learnjava_1206;

import java.util.Scanner;

public class 跟奥巴马一起编程 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            String ch = sc.next();
            helper(x,ch);
        }
    }
    private static void helper(int x,String ch){
        for(int i = 0;i < x;i++){
            System.out.print(ch);
        }
        System.out.println();
        for(int i = 1;i <= Math.ceil((double) x / 2 - 2);i++){
            System.out.print(ch);
            for(int j = 2;j <= x - 1;j++){
                System.out.print(" ");
            }
            System.out.println(ch);
        }
        for(int i = 0;i < x;i++){
            System.out.print(ch);
        }
    }
}
