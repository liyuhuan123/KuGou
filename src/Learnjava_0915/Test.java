package Learnjava_0915;

public class Test {
    //链表中的倒数第K个结点
    // https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head;
        ListNode latter = head;
        for(int i = 0;i < k;i++){
            former = former.next;
        }
        while(former != null){
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
