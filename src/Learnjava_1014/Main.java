package Learnjava_1014;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Main {
    //二叉树的高度
    private static int getHigh(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftDepth = getHigh(root.left);
        int rightDepth = getHigh(root.right);
        return Math.max(leftDepth,rightDepth) + 1;

    }
    //二叉树的层序遍历
    private static void levelTravel(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }
}
