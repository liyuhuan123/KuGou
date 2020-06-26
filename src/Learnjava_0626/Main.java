package Learnjava_0626;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Main {
    public static void main(String[] args) {

    }
    //二叉树的平衡性检查
    public boolean isBalance(TreeNode root) {
        // write code here
        if(root == null){
            return true;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(Math.abs(left - right) > 1){
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
    private int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
