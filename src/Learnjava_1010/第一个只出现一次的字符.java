package Learnjava_1010;

import java.util.HashMap;
import java.util.Map;

//链接https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
public class 第一个只出现一次的字符 {
    //方法1
    public char firstUniqChar(String s) {
        if(s.length() == 0 || s == null){
            return ' ';
        }
        s = s.toLowerCase();
        int[] arr = new int[26];
        for(int i = 0;i < s.length();i++){
            arr[s.charAt(i) - 'a']++;
        }
        for(int i = 0;i < s.length();i++){
            if(arr[s.charAt(i) - 'a'] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
    //方法2
    public static char firstUniqChar2(String s){
        if(s == null || s.length() == 0){
            return ' ';
        }
        s = s.toLowerCase();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            char temp = s.charAt(i);
            if(map.containsKey(temp)){
                map.replace(temp,map.get(temp) + 1);
            }else{
                map.put(temp,1);
            }
        }
        for(int i = 0;i < s.length();i++){
            char temp = s.charAt(i);
            if(map.get(temp) == 1){
                return temp;
            }
        }
        return ' ';

    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar2(s));
    }
}
