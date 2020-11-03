package Learnjava_1103;
//(https://leetcode-cn.com/problems/find-the-difference/)
public class 找不同 {
    public char findTheDifference(String s, String t) {
        int length = s.length();
        char temp = 0;
        for(int i = 0;i < length;i++){
            temp ^= s.charAt(i);
            temp ^= t.charAt(i);
        }
        temp ^= t.charAt(t.length() - 1);
        return temp;
    }
}
