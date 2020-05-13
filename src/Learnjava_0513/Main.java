package Learnjava_0513;

import java.util.Arrays;
import java.util.Scanner;
//访友
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] arr = new int[3];
            for(int i = 0;i < 3;i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 0;i < arr.length;i++){
                for(int j = i + 1;j < arr.length;j++){
                    if(arr[i] < arr[j]){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            System.out.println(arr[0] - arr[1] + arr[1] - arr[2]);
        }
    }
}
