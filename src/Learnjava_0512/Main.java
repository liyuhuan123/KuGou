package Learnjava_0512;

import java.util.Scanner;

public class Main {
    //模数求和
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int x;
            int sum = 0;
            for(int i = 0;i < n;i++){
                x = sc.nextInt();
                sum += (x - 1);
            }
            System.out.println(sum);
        }
    }
}
