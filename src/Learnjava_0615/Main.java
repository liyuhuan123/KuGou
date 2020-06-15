package Learnjava_0615;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
//最长公共前缀
public String longestCommonPrefix(String[] strs) {
    if(strs.length == 0){
        return "";
    }
    if(strs == null){
        return null;
    }
    if(strs.length == 1){
        return strs[0];
    }
    String str = strs[0];
    for(int i = 1;i < strs.length;i++){
        if(str.length() == 0 || strs[i].length() == 0){
            return"";
        }
        int length = Math.min(str.length(),strs[i].length());
        int j;
        for(j =0;j < length;j++){
            if(str.charAt(j) != strs[i].charAt(j)){
                break;
            }
        }
        str = str.substring(0,j);
    }
    return str;
}
//栈的压入、弹出序列
public boolean validateStackSequences(int[] pushed, int[] popped) {
    if(pushed.length == 0 && popped.length == 0){
        return true;
    }
    if(pushed.length != popped.length){
        return false;
    }
    Stack<Integer> stack = new Stack<>();//模拟压栈和入栈
    int index = 0;//出栈位置的索引
    for(int i = 0;i < pushed.length;i++){
        stack.push(pushed[i]);
        while(!stack.isEmpty() && stack.peek() == popped[index]){
            stack.pop();
            index++;
        }
    }
    return stack.isEmpty();
}
//删除排序数组的重复项
    public int removeDuplicates(int[] nums){
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int count = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[count] != nums[i]){
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }
}
