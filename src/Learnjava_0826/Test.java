package Learnjava_0826;

import java.util.*;

public class Test {
    //旧键盘上坏了几个键，于是在敲一段文字的时候，
    // 对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，
    // 请你列出
    //肯定坏掉的那些键。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String str3 = str1.toUpperCase();
            String str4 = str2.toUpperCase();
            List<Character> list = new ArrayList<>();
            Set<Character> set = new HashSet<>();
            for(int i = 0;i < str2.length();i++){
                set.add(str4.charAt(i));
            }
            for(int i = 0;i < str3.length();i++){
                if(set.contains(str3.charAt(i)) || list.contains(str3.charAt(i))){
                    continue;
                }else{
                    list.add(str3.charAt(i));
                }
            }
            for(int i = 0;i < list.size();i++){
                System.out.print(list.get(i));
            }
        }
    }
}
