package Learnjava_1004;
//链接:https://leetcode-cn.com/problems/string-rotation-lcci/
public class 字符串轮转 {
    //方法1
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s2.equals(s1)){
            return true;
        }
        boolean flag = false;
        for(int i = 0;i < s1.length();i++){
            String temp = s1.substring(i) + s1.substring(0,i);
            if(s2.equals(temp)){
                flag = true;
            }
        }
        return flag;
    }
    //方法2
    public boolean isFlipedString2(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        String temp = s2 + s2;
        if(temp.contains(s1)){
            return true;
        }
        return false;
    }
}
