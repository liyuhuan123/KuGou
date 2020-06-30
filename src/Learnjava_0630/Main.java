package Learnjava_0630;

import java.util.Scanner;

public class Main {
    //找x
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            int toFind = sc.nextInt();
            int i = 0;
            int count = -1;
            while(i < n) {
                if (arr[i] == toFind) {
                    count = i;
                    break;
                }else{
                    count = -1;
                }
            }
                System.out.println(count);
        }
    }
}
