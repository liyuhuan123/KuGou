package Learnjava_21_0307;
//链接:https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                newTail.next = l1;
                l1 = l1.next;
                newTail = newTail.next;
            }else{
                newTail.next = l2;
                l2 = l2.next;
                newTail = newTail.next;
            }
        }
        if(l1 != null){
            newTail.next = l1;
        }
        if(l2 != null){
            newTail.next = l2;
        }
        return newHead.next;
    }
}
