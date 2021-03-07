package Learnjava_21_0307;
//链接:https://leetcode-cn.com/problems/linked-list-cycle-ii/
public class 环形链表II {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        ListNode prev = fast;
        ListNode cur = head;
        if(fast == null || fast.next == null){
            return null;
        }
        while(cur != prev){
            cur = cur.next;
            prev = prev.next;
        }
        return cur;
    }
}
