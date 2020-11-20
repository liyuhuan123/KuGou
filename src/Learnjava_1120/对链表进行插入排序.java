package Learnjava_1120;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class 对链表进行插入排序 {

        public ListNode insertionSortList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode result = new ListNode(head.val);
            ListNode pre = head.next;
            while(pre != null){
                ListNode cur = pre;
                pre = pre.next;
                //直接进行链表的头插操作
                if(result.val >= cur.val){
                    cur.next = result;
                    result = cur;
                    continue;
                }
                ListNode temp = result;
                ListNode node = temp;
                while(temp != null && temp.val < cur.val){
                    node = temp;
                    temp = temp.next;
                }
                node.next = cur;
                node.next.next = temp;
            }
            return result;
        }
}
