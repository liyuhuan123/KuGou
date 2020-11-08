package Learnjava_1108;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
//链接：https://www.nowcoder.com/practice/37548e94a270412c8b9fb85643c8ccc2?tpId=188&&tqId=36321&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
public class 括号序列 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        char[] arr = s.toCharArray();
        for (char temp : arr) {
            if (map.containsKey(temp)) {
                stack.push(temp);
            } else if (map.containsValue(temp)) {
                if(stack.isEmpty()){
                    return false;
                }
                char current = stack.pop();
                if (map.get(current) != temp) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
