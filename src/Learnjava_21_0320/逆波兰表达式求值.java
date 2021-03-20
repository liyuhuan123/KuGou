package Learnjava_21_0320;
//链接:https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
import java.util.Stack;

public class 逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String temp = tokens[i];
            if (temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")) {
                Integer temp1 = stack.pop();
                Integer temp2 = stack.pop();
                Integer result = 0;
                if (temp.equals("+")) {
                    result = temp1 + temp2;
                } else if (temp.equals("-")) {
                    result = temp2 - temp1;
                } else if (temp.equals("*")) {
                    result = temp2 * temp1;
                } else if (temp.equals("/")) {
                    result = temp2 / temp1;
                }
                stack.push(result);
            } else {
                Integer cur = Integer.valueOf(temp);
                stack.push(cur);
                continue;
            }
        }
        return stack.pop();
    }
}
