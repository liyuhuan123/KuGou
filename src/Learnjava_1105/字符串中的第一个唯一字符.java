package Learnjava_1105;

import java.util.HashMap;
import java.util.Map;
//https://leetcode-cn.com/problems/first-unique-character-in-a-string/

public class 字符串中的第一个唯一字符 {
        public int firstUniqChar(String s) {
            Map<Character,Integer> map = new HashMap<>();
            for(int i = 0;i < s.length();i++){
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
                }else{
                    map.put(s.charAt(i),1);
                }
            }
            for(int i = 0;i < s.length();i++){
                if(map.get(s.charAt(i)) == 1){
                    return i;
                }
            }
            return -1;
        }
}
