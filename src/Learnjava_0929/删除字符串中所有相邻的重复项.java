package Learnjava_0929;

import java.util.Stack;

//链接https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
public class 删除字符串中所有相邻的重复项 {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < S.length();i++){
            char temp = S.charAt(i);
            if(stack.isEmpty()){
                stack.push(temp);
            }else{
                if(stack.peek() == temp){
                    stack.pop();
                }else{
                    stack.push(temp);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
