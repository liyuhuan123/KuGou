package Learnjava_21_0316;

public class 平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftDepth = getHeight(root.left);
        int rightDepth = getHeight(root.right);
        int subb = leftDepth - rightDepth;
        return (subb >= -1 && subb <= 1) && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = getHeight(root.left);
        int rightDepth = getHeight(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}
