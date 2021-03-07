package Learnjava_21_0307;
//链接:https://www.nowcoder.com/practice/0e27e0b064de4eacac178676ef9c9d70?
//tpId=8&&tqId=11004&rp=2&ru=/activity/oj&qru=/ta/cracking-the-coding-interview/questionranking
public class 链表分割 {
    public ListNode partition(ListNode pHead, int x) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        while(pHead != null){
            if(pHead.val < x){
                smallTail.next = new ListNode(pHead.val);
                pHead = pHead.next;
                smallTail = smallTail.next;
            }else{
                bigTail.next = new ListNode(pHead.val);
                pHead = pHead.next;
                bigTail = bigTail.next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}
