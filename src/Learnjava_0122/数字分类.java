package Learnjava_0122;

import java.util.Scanner;

public class 数字分类 {
    public static void main(String[] args) {
        int count;
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        int A[] = new int[5];
        int count1 = 0;
        int count3 = 0;

        int[] input = new int[1000];
        for(int i = 0; i < count; i++) {
            input[i] = sc.nextInt();
            if(input[i] % 10 == 0) {
                A[0] += input[i];
            }else if(input[i] % 5 == 1) {
                count1++;
                if(count1 % 2 == 0) {
                    A[1] -= input[i];
                }
                else {
                    A[1] += input[i];
                }

            }
            else if(input[i]%5 == 2) {
                A[2]++;
            }
            else if(input[i]%5 == 3) {
                A[3] += input[i];
                count3++;
            }
            else if(input[i]%5 == 4) {
                if(input[i]>A[4])
                    A[4] = input[i];
            }
            else {
                continue;
            }

        }
        //A4 = A4 / count4;
        for(int i = 0;i<3;i++) {
            if(i == 1) {
                if(count1 ==0) {
                    System.out.print("N ");
                }
                else {
                    System.out.print(A[i]+" ");
                }
            }
            else {
                if(A[i]==0) {
                    System.out.print("N ");
                }
                else {
                    System.out.print(A[i]+" ");
                }
            }
        }
        if(A[3]==0) {
            System.out.print("N ");
        }
        else {
            System.out.printf("%.1f ",(float)A[3]/count3);
        }
        if(A[4]==0) {
            System.out.print("N");
        }
        else {
            System.out.print(A[4]);
        }

    }

}

