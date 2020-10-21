package Learnjava_1021;
class ListNode{
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
    }
}
public class 合并两个排序的链表 {
    //1.递归写法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode newNode = null;
        if(l1.val < l2.val){
            newNode = l1;
            newNode.next = mergeTwoLists(l1.next,l2);
        }else{
            newNode = l2;
            newNode.next = mergeTwoLists(l1,l2.next);
        }
        return newNode;

    }
    //2.非递归写法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //合并后的链表
        ListNode result = new ListNode(0);
        //临时结点
        ListNode tmp = result;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }else{
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if(l1 != null){
            tmp.next = l1;
        }
        if(l2 != null){
            tmp.next = l2;
        }
        return result.next;

    }

}
