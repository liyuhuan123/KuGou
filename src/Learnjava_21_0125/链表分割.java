package Learnjava_21_0125;

public class 链表分割 {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        while(pHead != null){
            if(pHead.val < x){
                smallTail.next = pHead;
                smallTail = smallTail.next;
            }else{
                bigTail.next = pHead;
                bigTail = bigTail.next;
            }
            pHead = pHead.next;
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}
