package Learnjava_21_0207;
//链接:https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class 从尾到头打印链表 {
    //方法1:利用栈特性
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null){
            return list;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = listNode;
        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
    //方法2:逆置数组
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null){
            return list;
        }
        while(listNode !=null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while(start < end){
            Integer temp = list.get(start);
            list.set(start,list.get(end));
            list.set(end,temp);
            start++;
            end--;
        }
        return list;
    }
    //方法3:递归方式
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(listNode,list);
        return list;
    }
    public static void helper(ListNode listNode,ArrayList<Integer> list){
        if(listNode == null){
            return;
        }
        helper(listNode.next,list);
        list.add(listNode.val);
    }

}
