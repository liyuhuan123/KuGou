package Learnjava_21_0307;
//链接:https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
public class 反转一个单链表 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
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
}
