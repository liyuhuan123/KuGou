package Learnjava_1027;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
//https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
public class 二叉树的前序遍历 {
    //递归实现
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null){
            result.add(root.val);
            List<Integer> leftList = preorderTraversal(root.left);
            result.addAll(leftList);
            List<Integer> rightList = preorderTraversal(root.right);
            result.addAll(rightList);
        }
        return result;
    }
    //非递归实现---借助栈模拟递归过程
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
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
