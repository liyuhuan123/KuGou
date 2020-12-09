package Learnjava_1209;

import java.util.*;

public class 洗牌{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int m = 0;m < T;m++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[2 * n];
            for(int i = 0;i < 2 * n;i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 0;i < k;i++){
                helper(arr,2 * n);
            }
            for(int i = 0; i < n * 2 - 1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(arr[n * 2 - 1]);
        }
    }
    private static void helper(int[] a, int n) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n / 2; i ++) {
            list.add(a[i]);
            list.add(a[i + n / 2]);
        }
        for (int i = 0; i < n; i ++) {
            a[i] = list.get(i);
        }
    }
}
