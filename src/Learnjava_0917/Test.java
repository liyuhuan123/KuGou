package Learnjava_0917;

import java.util.Arrays;
import java.util.Stack;

public class Test {
    //拿硬币
    // https://leetcode-cn.com/problems/na-ying-bi/
    public int minCount(int[] coins) {
        int count = 0;
        for(int i = 0;i < coins.length;i++){
            if(coins[i] % 2 == 0){
                count += coins[i] / 2;
            }else{
                count += coins[i] / 2 + 1;
            }
        }
        return count;
    }
    //将每个元素替换为右侧最大元素
    // https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/submissions/
    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        int max = arr[arr.length - 1];
        for(int i = arr.length - 2;i >= 0;i--){
            res[i] = max;
            if(arr[i] > max){
                max = arr[i];
            }
        }
        res[arr.length - 1] = -1;
        return res;
        }
        //数组中两元素的最大乘积
        // https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/
        public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
        }
        //删除最外层的括号
        // https://leetcode-cn.com/problems/remove-outermost-parentheses/submissions/
        public String removeOuterParentheses(String S) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int start = 0;
        int end = 0;
        boolean flag = false;
        int length = S.length();
        for(int i = 0;i < length;i++){
            char ch = S.charAt(i);
            if(ch == '('){
                stack.push(ch);
                if(!flag){
                    start = i;
                    flag = true;
                }
            }
            if(ch == ')'){
                stack.pop();
                if(stack.isEmpty()){
                    end = i;
                    ans.append(S.substring(start + 1,end));
                    flag = false;
                    start = end;
                    }
                }
            }
        return ans.toString();
        }
    }
