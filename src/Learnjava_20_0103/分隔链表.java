package Learnjava_20_0103;
//链接:https://leetcode-cn.com/problems/partition-list/
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class 分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode cur = head;
        ListNode l1 = head1;
        ListNode l2 = head2;
        while(cur != null){
            if(cur.val < x){
                l1.next = cur;
                cur = cur.next;
                l1 = l1.next;
                l1.next = null;
            }else{
                l2.next = cur;
                cur = cur.next;
                l2 = l2.next;
                l2.next = null;
            }
        }
        l1.next = head2.next;
        return head1.next;
    }
}
