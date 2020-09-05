package Learnjava_0905;

import java.util.Scanner;

public class homework {
    //交错01串--网易
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            panduan(str);
        }
    }

    private static void panduan(String str) {
        char[] arr = str.toCharArray();
        int res = 1;
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 1;
            }
        }
        System.out.println(res);
    }
}
