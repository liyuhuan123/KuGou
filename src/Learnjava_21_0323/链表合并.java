package Learnjava_21_0323;

public class 链表合并 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //闭区间
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                newTail.next = l1;
                newTail = newTail.next;
                l1 = l1.next;
            }else{
                newTail.next = l2;
                newTail = newTail.next;
                l2 = l2.next;
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
