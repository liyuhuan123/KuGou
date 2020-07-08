package Learnjava_0708;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        //Broken KeyBoard
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine().toUpperCase();
            String str2 = sc.nextLine().toUpperCase();

            Set<Character> result = new HashSet<>();
            Set<Character> temp = new HashSet<>();
            for(int i = 0;i < str2.length();i++){
                result.add(str2.charAt(i));
            }
            for(int i = 0;i < str1.length();i++){
                if(!result.contains(str1.charAt(i))){
                    if(!temp.add(str1.charAt(i))){
                        System.out.print(str1.charAt(i));
                    }
                }
            }
        }
    }
}
