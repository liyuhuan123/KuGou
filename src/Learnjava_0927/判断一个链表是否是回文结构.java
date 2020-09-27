package Learnjava_0927;

import java.util.ArrayDeque;
import java.util.Deque;

class ListNode {
    int val;
    ListNode next = null;


}
public class 判断一个链表是否是回文结构 {
    public boolean isPail (ListNode head) {
        // write code here
        if(head == null || head.next == null){
            return true;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        while(head != null){
            deque.addFirst(head.val);
            head = head.next;
        }
        while(deque.size() > 1){
            if(deque.pollFirst() != deque.pollLast()){
                return false;
            }
        }
        return true;
    }
}
