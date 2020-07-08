package Learnjava_0708;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //锥子剪刀布
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            String[] str = new String[N];
            for(int i = 0;i < N;i++){
                str[i] = sc.nextLine();
            }
            helper(str);
        }

    }
    private static void helper(String[] str) {
        int win = 0;//记录甲胜的次数
        int fail = 0;//记录甲败的次数
        int draw = 0;//平局次数
        int[] arrA = new int[3];
        int[] arrB = new int[3];
        for(int i = 0;i < str.length;i++){
            char A = str[i].charAt(0);
            char B = str[i].charAt(2);
            if(A == B){
                draw++;
            }
            if(A == 'C' && B == 'J'){
                win++;
                arrA[1]++;
            }else if(A == 'J' && B == 'B'){
                win++;
                arrA[2]++;
            }else if(A == 'B' && B == 'C'){
                win++;
                arrA[0]++;
            }else if(A == 'J' && B == 'C'){
                fail++;
                arrB[1]++;
            }else if(A == 'B' && B == 'J'){
                fail++;
                arrB[2]++;
            }else if(A == 'C' && B == 'B'){
                fail++;
                arrB[0]++;
            }

    }
        System.out.println(win + " " + draw + " " + " " + fail);
        System.out.println(fail + " " + draw + " " + win);
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        if(arrA[2] == arrA[1] && arrA[1] == arrA[0]){
            System.out.print("B" + " ");
        }else if(arrA[2] == arrA[1]){
            System.out.print("C" + " ");
        }else{
            System.out.print("J" + " ");
        }
        if(arrB[2] == arrB[1] && arrB[1] == arrB[0]){
            System.out.print("B");
        }else if(arrB[2] == arrB[1]){
            System.out.print("C");
        }else{
            System.out.print("J");
        }
    }
}
