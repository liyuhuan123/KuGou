package LearnJava_0830;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            System.out.println(buy(N));
        }
    }
    private static int buy(int N){
        if(N < 6 || N == 10 || N % 2 != 0){
            return -1;
        }
        if(N % 8 == 0){
            return N / 8;
        }
        return 1 + N / 8;

    }
}