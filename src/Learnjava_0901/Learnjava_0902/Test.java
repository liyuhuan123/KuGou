package Learnjava_0901.Learnjava_0902;

import java.util.Scanner;

public class Test {
    //给定5个正整数, 它们的最小的众倍数是指的能够被其中至少三个数整除的最小正整数。
    //给定5个不同的正整数, 请计算输出它们的最小众倍数。
    //最小众倍数
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] arr = new int[5];
            for(int i = 0;i < arr.length;i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(find(arr));
        }
    }

    private static int find(int[] arr) {
        int i = 1;
        int count = 0;
        while(i > 0){
            if(i % arr[0] == 0){
                count++;
            }
            if(i % arr[1] == 0){
                count++;
            }
            if(i % arr[2] == 0){
                count++;
            }
            if(i % arr[3] == 0){
                count++;
            }
            if(i % arr[4] == 0){
                count++;
            }
            if(count >= 3){
                break;
            }
            count = 0;
            i++;
        }
        return i;
    }

}
