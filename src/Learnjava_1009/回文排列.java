package Learnjava_1009;

import java.util.HashSet;
import java.util.Set;
//链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci/
public class 回文排列 {
    //方法1
    public boolean canPermutePalindrome(String s) {
        if(s.length() == 0 || s == null){
            return true;
        }
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < s.length();i++){
            char temp = s.charAt(i);
            if(set.contains(temp)){
                set.remove(temp);
            }else{
                set.add(temp);
            }
        }
        if(set.size() > 1){
            return false;
        }
        return true;
    }
    //方法2
    private boolean canPermutePalindrome2(String s) {
        int[] count = new int[128];
        char[] ch = s.toCharArray();
        for(int i = 0;i < s.length();i++){
            count[(int)ch[i]]++;
        }
        int mark = 0;
        for(int i = 0;i < 128;i++){
            if(count[i] % 2 == 1){
                mark++;
            }
            if(mark > 1){
                return false;
            }
        }
        return true;
    }
}
