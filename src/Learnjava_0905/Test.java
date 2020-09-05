package Learnjava_0905;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    //数字游戏
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0;i < N;i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(helper(arr));
        }
    }

    private static int  helper(int[] arr) {
        if(arr[0] > 1){
            return 1;
        }
        if(arr.length == 1){
            return arr[0] + 1;
        }
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] - count > 1){
                break;
            }
            count += arr[i];
        }
        return count + 1;

    }
}
