package Learnjava_1026;

public class 对称的二叉树 {
    //https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric_Helper(root.left,root.right);
    }
    private boolean isSymmetric_Helper(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSymmetric_Helper(p.left,q.right) && isSymmetric_Helper(p.right,q.left);
    }
}
