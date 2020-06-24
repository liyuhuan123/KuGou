package Learnjava_0624;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //到底买不买
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int[] str1Arr = new int[128];
            for(int i = 0;i < str1.length();i++){
                str1Arr[str1.charAt(i)]++;
            }
            boolean temp = false;
            int count = 0;
            for(int i = 0;i < str2.length();i++){
                int index = str2.charAt(i);
                if(str1Arr[index] != 0){
                    str1Arr[index]++;
                }else{
                    temp = true;
                    count++;
                }
            }
            if(temp){
                System.out.println("No" + " " + count);
            }else{
                System.out.println("Yes" + " " + (str1.length() - str2.length()));
            }
        }

    }
}
