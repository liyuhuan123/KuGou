package Learnjava_0628;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //学分绩点
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();//总的课程数
            int[] score = new int[n];//相应课程的学分
            int[] arr = new int[n];//课程实际得分
            for(int i = 0;i < n;i++){
                score[i] = sc.nextInt();
            }
            for(int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            helper_jidian(arr,score);
        }

    }

    private static void helper_jidian(int[] arr,int[] score) {
        double[] result = new double[arr.length];
        for(int i = 0;i < arr.length;i++){
            if(arr[i] >= 90 && arr[i] <= 100){
                result[i] = 4.0 * score[i];
            }else if(arr[i] >= 85 && arr[i] <= 89){
                result[i] = 3.7 * score[i];
            }else if(arr[i] >= 82 && arr[i] <= 84){
                result[i] = 3.3 * score[i];
            }else if(arr[i] >= 78 && arr[i] <= 81){
                result[i] = 3.0 * score[i];
            }else if(arr[i] >= 75 && arr[i] <= 77){
                result[i] = 2.7 * score[i];
            }else if(arr[i] >= 72 && arr[i] <= 74){
                result[i] = 2.3 * score[i];
            }else if(arr[i] >= 68 && arr[i] <= 71){
                result[i] = 2.0 * score[i];
            }else if(arr[i] >= 64 && arr[i] <= 67){
                result[i] = 1.5 * score[i];
            }else if(arr[i] >= 60 && arr[i] <= 63){
                result[i] = 1.0 * score[i];
            }else if(arr[i] < 60){
                result[i] = 0;
            }
        }
        double count_jidian = 0;
        int count_score = 0;
        for(int i = 0;i < result.length;i++){
            count_jidian += result[i];
            count_score += score[i];
        }
        double GPA = count_jidian / count_score;
        System.out.printf("%.2f",GPA);
        System.out.println();
    }
}
