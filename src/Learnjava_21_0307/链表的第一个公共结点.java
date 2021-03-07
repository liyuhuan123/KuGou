package Learnjava_21_0307;

import java.util.ArrayList;

//链接:https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
public class 链表的第一个公共结点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList<ListNode> list = new ArrayList<>();
        while(headA != null){
            list.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(list.contains(headB)){
                return headB;
            }else{
                headB = headB.next;
            }
        }
        return null;
    }
}
