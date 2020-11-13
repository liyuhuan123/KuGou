package Learnjava_1113;
//链接:https://leetcode-cn.com/problems/odd-even-linked-list/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class 奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //指向奇数结点的末尾
        ListNode ji = head;
        //指向偶数结点的末尾
        ListNode ou = head.next;
        while(ou != null && ou.next != null){
            //临时变量,指向偶结点的开头
            ListNode temp = ji.next;
            ji.next = ou.next;
            ou.next = ou.next.next;
            ji.next.next = temp;
            ji = ji.next;
            ou = ou.next;

        }
        return head;
    }
}
