package Learnjava_1003;

import java.util.ArrayList;
import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 //链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        int index = 0;
        for(int i = list.size() - 1;i >= 0;i--){
            res[index] = list.get(i);
            index++;
        }
        return res;
    }
}
