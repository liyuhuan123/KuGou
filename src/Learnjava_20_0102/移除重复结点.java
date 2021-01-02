package Learnjava_20_0102;
//链接https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
import java.util.HashSet;
import java.util.Set;

class ListNode {
 int val;
 ListNode next;
 ListNode(int x) { val = x; }
 }

public class 移除重复结点 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode result = head;
        while(result.next != null){
            ListNode cur = result.next;
            if(set.add(cur.val)){
                result = result.next;
            }else{
                result.next = result.next.next;
            }
        }
        return head;
    }
}
