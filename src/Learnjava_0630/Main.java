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
            int m = sc.nextInt();
            System.out.println(Look(arr,n,m));
        }
    }
    private static int Look(int[] arr,int n,int m){
        for(int i = 0;i < n;i++){
            if(arr[i] == m){
                return i;
            }
        }
        return -1;
    }
}
