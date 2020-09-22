package Learnjava_0922;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class excise {
    //有效的括号
    // https://leetcode-cn.com/problems/valid-parentheses/submissions/
    public boolean isValid(String s){
        Deque<Character> stack = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for(char c : charArray){
            switch(c){
                case '(':
                    case '[':
                        case '{':
                            stack.push(c);
                            break;
                default:{
                    if(stack.isEmpty()){
                        return false;
                    }
                    char left = stack.pop();
                    if(!compareBracket(left,c)){
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    private static boolean compareBracket(char left,char c){
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for(Map.Entry<Character,Character> entry : map.entrySet()){
            if(entry.getKey() == left && entry.getValue() == c){
                return true;
            }
        }
        return false;
//        if(left == '(' && c == ')'){
//            return true;
//        }else if(left == '{' && c == '}'){
//            return true;
//        }else if(left == '[' && c == ']'){
//            return true;
//        }else{
//            return false;
//        }
//

    }
}
