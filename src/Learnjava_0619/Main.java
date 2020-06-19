package Learnjava_0619;

import java.util.Scanner;

public class Main {
    //统计同成绩学生人数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            int[] score = new int[N];
            while(N > 0){
                score[N - 1] = sc.nextInt();
                N--;
            }
            int target = sc.nextInt();
            int count = 0;
            for(int x : score){
                if(x == target){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
