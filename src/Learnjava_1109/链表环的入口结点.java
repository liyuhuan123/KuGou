package Learnjava_1109;
//https://www.nowcoder.com/practice/6e630519bf86480296d0f1c868d425ad?tpId=188&tqId=36321&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking
public class 链表环的入口结点 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        ListNode cur = fast;
        ListNode pre = head;
        if(fast == null || fast.next == null){
            return null;
        }
        while(pre != null){
            if(cur == pre){
                break;
            }
            cur = cur.next;
            pre = pre.next;
            if(cur == pre){
                break;
            }
        }
        return pre;
    }
}
