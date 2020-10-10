package Learnjava_1010;

import java.util.Stack;

//链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class 二叉树的镜像 {
    //1.递归实现
    public TreeNode mirrorTree(TreeNode root) {
        if(root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }
    //2.非递归实现
    //借助栈或者队列遍历书中每一个非叶子结点，交换其左右子树即可
    public TreeNode mirrorTree2(TreeNode root){
        if(root == null){
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        return root;
    }
}
