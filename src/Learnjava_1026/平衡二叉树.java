package Learnjava_1026;
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
//https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
public class 平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftHeight = getHigh(root.left);
        int rightHeight = getHigh(root.right);
        int subb = rightHeight - leftHeight;
        return subb <= 1 && subb >= -1 &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }
    private int getHigh(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null || root.right == null){
            return 2;
        }
        return Math.max(getHigh(root.left),getHigh(root.right)) + 1;
    }
}
