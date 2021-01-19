package Learnjava_21_0119;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class 链表分割 {
    public ListNode partition(ListNode pHead, int x) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode bigHead = new ListNode(-1);
        ListNode smallHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode smallTail = smallHead;
        ListNode curNode = pHead;
        while(curNode != null){
            if(curNode.val < x){
                smallTail.next = new ListNode(curNode.val);
                smallTail = smallTail.next;
            }else{
                bigTail.next = new ListNode(curNode.val);
                bigTail = bigTail.next;
            }
            curNode = curNode.next;
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}
