package Learnjava_1124;

import java.util.Stack;

public class 合法括号序列判断 {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < A.length();i++){
            if(A.charAt(i) == '('){
                stack.push(A.charAt(i));
            }else if(A.charAt(i) == ')'){
                if(stack.isEmpty()){
                    return false;
                }else{
                    char temp = stack.pop();
                    if(temp != '('){
                        return false;
                    }
                }
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

}
