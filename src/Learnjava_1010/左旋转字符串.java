package Learnjava_1010;

public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        String res = "";
        res += s.substring(n,s.length()) + s.substring(s.length()) + s.substring(0,n);
        return res;
    }
}
