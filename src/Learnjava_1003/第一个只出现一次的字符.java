package Learnjava_1003;

import java.util.HashMap;
import java.util.Map;
//链接https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/submissions/
public class 第一个只出现一次的字符 {
    //方法1
    public char firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return ' ';
        }
        Map<Character,Integer> map = new HashMap<>();
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        for(char temp : arr){
            if(!map.containsKey(temp)){
                map.put(temp,1);
            }else{
                map.put(temp,map.get(temp) + 1);
            }
        }
        for(int i = 0;i < arr.length;i++){
            if(map.get(arr[i]) == 1){
                return arr[i];
            }
        }
        return ' ';
    }
    //方法2
    public char firstUniqChar2(String s) {
        if(s.length() == 0 || s == null){
            return ' ';
        }
        s = s.toLowerCase();
        int[] arr = new int[26];
        for(int i = 0;i < s.length();i++){
            char temp = s.charAt(i);
            arr[temp - 'a']++;
        }
        for(int i = 0;i < s.length();i++){
            if(arr[s.charAt(i) - 'a'] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
