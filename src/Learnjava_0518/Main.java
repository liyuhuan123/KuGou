package Learnjava_0518;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i = 0;i < n;i++){
                String str = sc.next();
                arr[i] = correct(str);
            }
            for(int i = 0;i < n;i++){
                System.out.println(arr[i]);
            }
        }
    }

    private static String correct(String str) {
        if(str.length() <= 2){
            return str;
        }
        for(int i = 0;i < str.length() - 3;i++){
            if(str.charAt(i) == str.charAt(i + 1) &&
            str.charAt(i) == str.charAt(i + 2)){
                str = delete(str,i);
                i--;
            }else{
                if(str.charAt(i) == str.charAt(i + 1)&&
                str.charAt(i + 2) == str.charAt(i + 3)){
                    str = delete(str,i);
                    i--;
                }
            }
        }
            if(str.charAt(str.length() - 1) == str.charAt(str.length() - 2) &&
            str.charAt(str.length() - 3) == str.charAt(str.length() - 1)){
                return str.substring(0,str.length() - 1);
            }
        return str;
    }

    private static String delete(String str, int i) {
        return str.substring(0,i + 2) + str.substring(i + 3);
    }
}
