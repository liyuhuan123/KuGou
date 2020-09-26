package Learnjava_0926;

import java.util.Stack;

public class Main {
    //比较含退格的字符串
    // https://leetcode-cn.com/problems/backspace-string-compare/
    public boolean backspaceCompare(String S, String T) {
        return helper(S).equals(helper(T));
    }
    private static String helper(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < str.length();i++){
            char temp = str.charAt(i);
            if(temp != '#'){
                stack.add(temp);
            }else if(!stack.isEmpty() && temp == '#'){
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }
}
