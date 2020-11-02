package Learnjava_1102;

import java.util.*;
//https://leetcode-cn.com/problems/most-common-word/
public class 最常见的单词 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        for(int i = 0;i < paragraph.length();i++){
            if(paragraph.charAt(i) == ',' ||
                    paragraph.charAt(i) == '.' ||
                    paragraph.charAt(i) == '!' ||
                    paragraph.charAt(i) == '?' ||
                    paragraph.charAt(i) == ';' ||
                    paragraph.charAt(i) == '\''){
                continue;
            }else{
                list.add(paragraph.charAt(i));
            }
        }
        String newStr = new String(String.valueOf(list));
        String[] str = newStr.toLowerCase().trim().split(" ");
        Map<String,Integer> map = new HashMap<>();
        for(String temp : str){
            if(!set.contains(temp)){
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp) + 1);
                }else{
                    map.put(temp,1);
                }
            }
        }
        String result = null;
        int max = 0;
        for(String temp : map.keySet()){
            if(map.get(temp) > max){
                max = map.get(temp);
                result = temp;
            }
        }
        return result;
    }
}
