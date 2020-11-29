package Learnjava_1129;

import java.util.Scanner;

public class 不要2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(helper(x,y));
        }
    }
    private static int helper(int x,int y){
        int[][] arr = new int[x][y];
        int count = 0;
        for(int i = 0;i < x;i++){
            for(int j = 0;j < y;j++){
                if(flag(arr,i,j)){
                    count++;
                    arr[i][j] = 2;
                }
            }
        }
        return count;
    }
    private static boolean flag(int[][] arr,int i,int j){
        if(j + 2 < arr[i].length && arr[i][j + 2] == 2){
            return false;
        }
        if(j - 2 >= 0 && arr[i][j - 2] == 2){
            return false;
        }
        if(i + 2 < arr.length && arr[i + 2][j] == 2){
            return false;
        }
        if(i - 2 >= 0 && arr[i - 2][j] == 2){
            return false;
        }
        return true;
    }
}
