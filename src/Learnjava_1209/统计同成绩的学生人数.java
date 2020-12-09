package Learnjava_1209;

import java.util.Scanner;
public class 统计同成绩的学生人数{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0;i < N;i++){
                arr[i] = sc.nextInt();
            }
            int score = sc.nextInt();
            helper(arr,score);
        }
    }
    private static void helper(int[] arr,int score){
        int result = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == score){
                result++;
            }
        }
        System.out.println(result);
    }
}
