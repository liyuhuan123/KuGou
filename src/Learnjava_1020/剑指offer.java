package Learnjava_1020;

import java.util.*;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class 剑指offer {
    //删除链表的结点
    //https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return null;
        }
        if(head.next == null && val == head.val){
            return null;
        }
        if(head.val == val){
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur.val != val && cur != null){
            pre = cur;
            cur = cur.next;
        }
        if(cur != null){
            pre.next = cur.next;
        }
        return head;
    }
    //从上到下打印二叉树
    //https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return result;
        }
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            result.add(new ArrayList<>());
            int size = queue.size();
            for(int i = 0;i < size;i++){
                TreeNode cur = queue.poll();
                result.get(level).add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            level++;
        }
        return result;
    }
    //用两个栈实现队列
    //https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public void CQueue() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }
    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            return -1;
        }else{
            int temp = stack2.pop();
            return temp;
        }
    }
    
}
