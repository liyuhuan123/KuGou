package Learnjava_0715;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //回文串
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            char[] arr = str.toCharArray();
            System.out.println(helper(arr));
        }
    }

    private static String helper(char[] arr) {
        int start = 0;
        int end = arr.length - 1;
        String res = "YES";
        while(start <= end){
            if(arr[start] == arr[end]){
                ++start;
                --end;
            }else if(arr[start] == arr[end - 1]){
                --end;
            }else if(arr[start + 1] == arr[end]){
                ++start;
            }else{
                res = "NO";
                break;
            }
        }
        return res;

    }
    //二维数组打印
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] res = new int[n * n];
        int index = 0;
        for(int y = n - 1;y > 0;y--){
            int i = 0;
            for(int j = y;j < n;){
                res[index++] = arr[i++][j++];
            }
        }
        for(int x = 0;x < n;x++){
            int j = 0;
            for(int i = x;i < n;){
                res[index++] = arr[i++][j++];
            }
        }
        return res;
    }
}
