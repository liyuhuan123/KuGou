package Learnjava_0704;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //奇偶校验
        while(sc.hasNext()){
            String str = sc.nextLine();
            helper(str.toCharArray());
        }
    }
    private static void helper(char[] arr){
        int[] result = new int[8];
        for(int i = 0;i < arr.length;i++){
            int n = 0x01;
            int j = 7;
            int sum = 0;
            while(j > 0){
                result[j] = (arr[i] & n) == 0 ? 0 : 1;
                if(result[j] == 1){
                    sum++;
                }
                n = n << 1;
                j--;
            }
            if((sum & 1) == 0){
                result[0] = 1;
            }
            for(int k = 0;k < result.length;k++){
                System.out.print(result[k]);
            }
            result[0] = 0;
            System.out.println();
        }
    }
}
