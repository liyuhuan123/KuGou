package Learnjava_21_0304;

import java.util.ArrayList;

public class 左旋转字符串 {
    public ArrayList<Integer> res = new ArrayList<>();
    public String LeftRotateString(String str,int n) {
        if(n >= str.length()){
            return str;
        }
        String str1 = str.substring(0,n);
        String str2 = str.substring(n,str.length());
        return str1 + str2;
    }
}
