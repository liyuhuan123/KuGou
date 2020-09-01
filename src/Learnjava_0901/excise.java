package Learnjava_0901;

import java.util.Scanner;

public class excise {
    //小易喜欢的单词具有以下特性：
    //1.单词每个字母都是大写字母
    //2.单词没有连续相等的字母
    //3.单词没有形如“xyxy”(这里的x，y指的都是字母，并且可以相同)这样的子序列，
    // 子序列可能不连续。
    //例如：
    //小易不喜欢"ABBA"，因为这里有两个连续的'B'
    //小易不喜欢"THETXH"，因为这里包含子序列"THTH"
    //小易不喜欢"ABACADA"，因为这里包含子序列"AAAA"
    //小易喜欢"A","ABA"和"ABCBA"这些单词
    //给你一个单词，你要回答小易是否会喜欢这个单词（只要不是不喜欢，就是喜欢）。
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(panduan(str));
        }
    }
    private static String panduan(String str){
        for(int i = 0;i < str.length() - 1;i++){
            char temp = str.charAt(i);
            if(temp > 'Z' || temp < 'A'){
                return "Dislikes";
            }else if(temp == str.charAt(i + 1)){
                return "Dislikes";
            }
        }
        for(int i = 0;i < str.length() - 3;i++){
            for(int j = i + 2;j < str.length() - 1;j++){
                if(str.charAt(i) == str.charAt(j)){
                    for(int m = i + 1;m < j;m++){
                        for(int n = j + 1;n < str.length();n++){
                            if(str.charAt(m) == str.charAt(n)){
                                return "Dislikes";
                            }
                        }
                    }
                }
            }
        }
        return "Likes";
    }
}
