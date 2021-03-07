package Learnjava_21_0307;
//链接:https://www.nowcoder.com/practice/d281619e4b3e4a60a2cc66ea32855bfa?
//tpId=49&&tqId=29370&rp=1&ru=/activity/oj&qru=/ta/2016test/question-ranking
public class 链表的回文结构 {
    public boolean chkPalindrome(ListNode A) {
        // write code here
        if (A == null) {
            return false;
        }
        if (A.next == null) {
            return true;
        }
        int steps = size(A) / 2;
        ListNode B = A;
        for(int i = 0;i < steps;i++){
            B = B.next;
        }
        ListNode cur = B;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            if(next == null){
                B = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        while(B != null){
            if(A.val != B.val){
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;
    }
    public int size(ListNode A){
        int size = 0;
        for(;A != null;A = A.next){
            size++;
        }
        return size;
    }

}
