package Learnjava_21_0301;
//链接:https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {
    public Map<Character,String> phoneMap = new HashMap<Character,String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        DFS(digits,result,"",0);
        return result;
    }
    public void DFS(String digits,List<String> allRet,String curStr,int idx){
        if(idx == digits.length()){
            allRet.add(curStr);
            return;
        }
        String strMap = phoneMap.get(digits.charAt(idx));
        for(int i = 0;i < strMap.length();i++){
            DFS(digits,allRet,curStr + strMap.charAt(i),idx + 1);
        }
    }
    public List<String> letterCombinations2(String digits) {
        List<String> strings = new ArrayList<>();
        if(digits.length() == 0){
            return strings;
        }
        String[] dict = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String[] arr = new String[digits.length()];
        for(int i = 0;i < digits.length();i++){
            arr[i] = dict[digits.charAt(i) - '0' - 2];
        }
        int startStr = 0;//循环下标
        group(arr,startStr,"",strings);
        return strings;
    }
    public String group(String[] arr,int startStr,String str,List<String> strings){
        char[] chars1 = arr[startStr].toCharArray();
        for(int j = 0;j < chars1.length;j++){
            if(startStr == arr.length - 1){
                strings.add(str + chars1[j]);
            }else{
                group(arr,startStr + 1,str + chars1[j],strings);
            }
        }
        return str;
    }
}
