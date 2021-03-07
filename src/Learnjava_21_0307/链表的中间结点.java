package Learnjava_21_0307;
//链接:https://leetcode-cn.com/problems/middle-of-the-linked-list/
public class 链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        if(head.next == null){
            return head;
        }
        int step = helper(head) / 2;
        int index = 0;
        while(index < step){
            head = head.next;
            index++;
        }
        return head;
    }
    public int helper(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}
