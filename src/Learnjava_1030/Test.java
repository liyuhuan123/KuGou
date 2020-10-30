package Learnjava_1030;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] bit = new int[32];
            for(int i = 31;i >= 0;i--){
                if(((1 << i) & n) != 0){
                    bit[i] = 1;
                    i++;
                }else{
                    bit[i] = 0;
                }
            }
            System.out.println(Arrays.toString(bit));
            for(int i = 31;i >= 0;i--){
                System.out.print(bit[i]);
                if(i != 0 && i != 31 && i % 4 == 0){
                    System.out.print("-");
                }
            }
        }
    }
}
