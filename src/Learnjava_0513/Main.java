package Learnjava_0513;

import java.util.Scanner;
//访友
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            int[] walk = {1,2,3,4,5};
            int sum = 0;
            int y = 0;
            for(int i = 4;i >= 0;i--){
                y = x / walk[i];
                x = x % walk[i];
                sum += y;
            }
            System.out.println(sum);
        }
    }
}
