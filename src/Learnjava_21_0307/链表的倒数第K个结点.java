package Learnjava_21_0307;
//链接:https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&rp=2&ru=%2Factivity%2Foj&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class 链表的倒数第K个结点 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null){
            return head;
        }
        int count = helper(head);
        if(count < k){
            return null;
        }
        count = count - k;
        while(count-- > 0){
            head = head.next;
        }
        return head;
    }
    public int helper(ListNode head){
        int count= 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}
