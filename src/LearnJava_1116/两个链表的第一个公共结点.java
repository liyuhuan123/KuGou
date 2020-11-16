package LearnJava_1116;

import java.util.ArrayList;
import java.util.List;

//链接:https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
public class 两个链表的第一个公共结点 {
    //方法1:
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int ALength = 0;//A链表的长度
        int BLength = 0;//B链表的长度

        ListNode A = headA;
        ListNode B = headB;
        //计算headA的长度
        while(A != null){
            ALength++;
            A = A.next;
        }
        //计算headB的长度
        while(B != null){
            BLength++;
            B = B.next;
        }

        //两个链表的长度差
        int temp = ALength - BLength;
        ListNode longList = headA;
        ListNode shortList = headB;
        if(temp < 0){
            longList = headB;
            shortList = headA;
            temp = (-1) * temp;
        }
        //让长的链表先走temp步
        for(int i = 0;i < temp;i++){
            longList = longList.next;
        }
        //此时长度相等,一起向前走
        while(longList != null && shortList != null && longList != shortList){
            longList = longList.next;
            shortList = shortList.next;
        }
        return longList;
    }
    //方法2:
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        List<ListNode> list = new ArrayList<>();
        while(headA != null){
            list.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(list.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
