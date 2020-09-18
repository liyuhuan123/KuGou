package Learnjava_0918;

import java.util.Arrays;
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class Test {
    //替换空格
    // https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
    public String replaceSpace(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < s.length();i++){
            char temp = s.charAt(i);
            if(temp != ' '){
                res.append(temp);
            }else{
                res.append("%20");
            }
        }
        return res.toString();
    }
    //判断是否能形成等差数列
    // https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence/
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int flag = arr[0] - arr[1];
        for(int i = 0;i < arr.length - 1;i++){
            if(arr[i] - arr[i + 1] != flag){
                return false;
            }
        }
        return true;
    }
    //反转链表
    // https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    //统计有序矩阵中的负数
    // https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[i].length;j++){
                if(grid[i][j] < 0){
                    count++;
                }
            }
        }
        return count;

    }
}
