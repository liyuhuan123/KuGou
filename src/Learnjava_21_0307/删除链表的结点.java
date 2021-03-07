package Learnjava_21_0307;
//链接:https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
class ListNode{
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
    }
}
public class 删除链表的结点 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return head;
        }
        if(head.val == val){
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null && cur.val != val){
            pre = cur;
            cur = cur.next;
        }
        if(cur != null){
            pre.next = cur.next;
        }
        return head;
    }
}
