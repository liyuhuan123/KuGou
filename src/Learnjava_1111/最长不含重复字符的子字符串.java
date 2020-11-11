package Learnjava_1111;

import java.util.LinkedList;
import java.util.Queue;

//链接:https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
public class 最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        char[] arr = s.toCharArray();
        int count = 0;
        for(char temp : arr){
            if(!queue.contains(temp)){
                queue.add(temp);
                int size = queue.size();
                count = count > size ? count : size;
            }else{
                int size = queue.size();
                count = count > size ? count : size;
                while(queue.peek() != temp){
                    queue.poll();
                }
                queue.poll();
                queue.offer(temp);
            }
        }
        return count;
    }

}
