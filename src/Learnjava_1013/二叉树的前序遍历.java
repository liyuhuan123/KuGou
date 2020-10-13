package Learnjava_1013;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//链接https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
public class 二叉树的前序遍历 {
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val){
            this.val = val;
        }
    }
    //非递归实现
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(!stack.isEmpty() || current != null){
            while(current != null){
                list.add(current.val);
                stack.push(current);
                current = current.left;
            }
            TreeNode top = stack.pop();
            current = top.right;
        }
        return list;
    }
}
