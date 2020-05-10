package Learnjava_0510;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            if(M > N){
                int temp = M;
                M = N;
                N = temp;
            }

            int count = isPrimNum(M,N);
            System.out.println();
        }
    }

    private static int isPrimNum(int m, int n) {
        int count = 0;
        while(m < n){
            int i;
            for(i = 2;i < Math.sqrt(m);i++){
                if(m % i == 0){
                    break;
                }
            }
            if(i == Math.sqrt(m)){
                count++;
            }
            m++;
        }
        return count;
    }
}
