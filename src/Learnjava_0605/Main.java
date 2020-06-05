package Learnjava_0605;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int[] weight;
    static int N;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            N = sc.nextInt();
            weight = new int[N + 1];
            for(int i = 1;i <= N;i++){
                weight[i] = sc.nextInt();
            }
            count(40,N);
            System.out.println(count);
        }
    }

    private static void count(int s, int n) {
        if(s == 0){
            count++;
            return;
        }
        if(s < 0 || (s > 0 && n < 1)){
            return;
        }
        count(s - weight[n],n - 1);
        count(s,n - 1);
    }
}
