package Learnjava_21_0316;

public class 对称的二叉树 {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return helper(pRoot.left,pRoot.right);
    }
    public boolean helper(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return helper(root1.left,root2.right);
    }
}
