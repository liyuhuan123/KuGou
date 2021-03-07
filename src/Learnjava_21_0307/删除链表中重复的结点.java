package Learnjava_21_0307;
//链接:https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?
//tpId=13&&tqId=11209&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
public class 删除链表中重复的结点 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        while(pHead != null){
            if(pHead.next != null && pHead.val == pHead.next.val){
                while(pHead.next != null && pHead.val == pHead.next.val){
                    pHead = pHead.next;
                }
                pHead = pHead.next;
            }else{
                newTail.next = new ListNode(pHead.val);
                newTail = newTail.next;
                pHead = pHead.next;
            }
        }
        return newHead.next;
    }
}
