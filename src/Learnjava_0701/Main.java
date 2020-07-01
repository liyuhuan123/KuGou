package Learnjava_0701;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //密码验证合格程序
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            helper(str);
        }
    }
    private static void helper(String str){
        int length = str.length();
        if(length <= 8) {
            System.out.println("NG");
            return;
        }
        int[] arr = new int[4];
        for(int i = 0;i < length;i++){
            if(str.charAt(i) >= 48 && str.charAt(i) <= 57){
                arr[0]++;
            }else if(str.charAt(i) >= 65 && str.charAt(i) <= 90){
                arr[1]++;
            }else if(str.charAt(i) >= 97 && str.charAt(i) <= 122){
                arr[2]++;
            }else{
                arr[3]++;
            }
        }
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] > 0){
                count++;
            }
        }

        if(count >= 3){
            boolean temp = compare(str);
            if(temp){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }else{
            System.out.println("NG");
        }
    }
    private static boolean compare(String str){
        boolean flag = true;
        for(int i = 0;i < str.length() - 2;i++){
            String temp = str.substring(i,i + 3);
            if(str.substring(i + 1).contains(temp)){
                flag = false;
            }
        }
        return flag;
    }
}
