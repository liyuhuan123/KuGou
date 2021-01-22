package Learnjava_0122;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class 二叉树平衡检查 {
    public boolean isBalance(TreeNode root) {
        // write code here
        if(root == null){
            return true;
        }
        int leftDepth = getHeight(root.left);
        int rightDepth = getHeight(root.right);
        int sub = leftDepth - rightDepth;
        return (sub >= -1 && sub <= 1) && isBalance(root.left) && isBalance(root.right);
    }
    private static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return (leftHeight > rightHeight ? leftHeight :rightHeight) + 1;
    }
}
