package Learnjava_0515;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //万万没想到之聪明的编辑
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            String str = sc.next();
            String[] arr = new String[N];
            for(int i = 0;i < N;i++){
                str = sc.next();
                arr[i] = editor(str);
            }
            for(int i = 0;i < N;i++) {
                System.out.println(arr[i]);
            }
        }
    }
    private static String editor(String str) {
        if(str.length() > 2) {
            for (int i = 0; i < str.length() - 3; i++) {
                if (str.charAt(i) == str.charAt(i + 1) &&
                        str.charAt(i) == str.charAt(i + 2)) {
                    str = del(str, i);
                    i--;
                } else {
                    if (str.charAt(i) == str.charAt(i + 1) &&
                            str.charAt(i + 2) == str.charAt(i + 3)) {
                        str = del(str, i + 2);
                        i--;
                    }
                }
            }
        }
        int n = str.length();
        if(str.charAt(n - 1) == str.charAt(n - 2) &&
        str.charAt(n - 1) == str.charAt(n - 3)){
            str = del(str,n - 1);
        }
        return str;
    }

    private static String del(String str, int i) {
        return str.substring(0,i) + str.substring(i + 1);
    }
}
