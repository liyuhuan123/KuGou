package Learnjava_1013;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
public class 二叉树的中序遍历 {
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //非递归实现
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(stack.isEmpty() || current != null){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            TreeNode top = stack.pop();
            list.add(top.val);
            current = top.right;
        }
        return list;
    }
}
