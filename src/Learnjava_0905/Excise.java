package Learnjava_0905;

import java.util.Arrays;
import java.util.Scanner;

public class Excise {
    //等差数列
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0;i < N;i++){
                arr[i] = sc.nextInt();
            }
            helper(arr);
        }
    }

    private static void helper(int[] arr) {
        Arrays.sort(arr);
        int temp = arr[1] - arr[0];
        for(int i = 0;i < arr.length - 1;i++){
            if(arr[i + 1] - arr[i] != temp){
                System.out.println("Impossible");
                return;
            }else{
                continue;
            }
        }
        System.out.println("possible");
    }
}
