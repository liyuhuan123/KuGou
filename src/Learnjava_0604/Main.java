package Learnjava_0604;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(delete(str1,str2));
        }
    }

    private static String delete(String str1, String str2) {
        for(int i = 0;i < str1.length();i++){
            for(int j = 0;j < str2.length();j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    str1 = deleteHelper(str1,i);
                }
            }
        }
        return str1;
    }

    private static String deleteHelper(String str1, int i) {
        return str1.substring(0,i) + str1.substring(i + 1);
    }
}
