package Learnjava_0515;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            String line;
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                line = sc.next();
                 arr[i] = Integer.parseInt(line.substring(line.length() - 6,line.length()));
            }
            Arrays.sort(arr);
            for(int i = 0;i < arr.length;i++){
                System.out.println(arr[i]);
            }
            }
        }
    }
