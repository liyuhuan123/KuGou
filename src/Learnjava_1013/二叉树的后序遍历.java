package Learnjava_1013;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//链接https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
public class 二叉树的后序遍历 {
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //非递归实现
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        TreeNode last = null;
        while(!stack.isEmpty() || current != null){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            TreeNode top = stack.peek();
            if(top.right == null){
                stack.pop();
                last = top;
                list.add(top.val);
            }else if(top.right == last){
                stack.pop();
                last = top;
                list.add(top.val);
            }else{
                current = top.right;
            }
        }
        return list;
    }
}
