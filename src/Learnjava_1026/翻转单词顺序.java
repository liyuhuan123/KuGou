package Learnjava_1026;

public class 翻转单词顺序 {
    public String reverseWords(String s){
        if(s.trim().length() == 0){
            return s;
        }
        String[] str = s.split(" ");
        String result = "";
        for(int i = str.length - 1;i >= 0;i--){
            result += str[i];
            result.trim();
            if(i > 0){
                result += " ";
            }
        }
        return result;
    }
}
