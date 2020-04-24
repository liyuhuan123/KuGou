package LearnJava_0424;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode root;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class review_tree {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return helper_pre(root,result);
    }

    private List<Integer> helper_pre
            (TreeNode root, List<Integer> result) {
        if(root == null){
            return result;
        }
        result.add(root.val);
        helper_pre(root.left,result);
        helper_pre(root.right,result);
        return result;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return helper_in(root,result);
    }

    private List<Integer> helper_in
            (TreeNode root, List<Integer> result) {
        if(root == null){
            return result;
        }
        helper_in(root.left,result);
        result.add(root.val);
        helper_in(root.right,result);
        return result;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return helper_post(root,result);
    }

    private List<Integer> helper_post
            (TreeNode root, List<Integer> result) {
        if(root == null){
            return result;
        }
        helper_post(root.left,result);
        helper_post(root.right,result);
        result.add(root.val);
        return result;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) &&
                isSameTree(p.right,q.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return helper_isSubtree(s,t);
    }

    private boolean helper_isSubtree(TreeNode s, TreeNode t) {
        return (s != null) && ((isSameTree(s,t))
                ||(helper_isSubtree(s.left,t))
                ||(helper_isSubtree(s.right,t)));
    }
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper_max(root);
    }

    private int helper_max(TreeNode root) {
        if(root == null){
            return 0;
        }
        int max = Math.max(helper_max(root.left),
                helper_max(root.right)) + 1;
        return max;
    }
    public boolean isBalanced(TreeNode root) {
        //1)它是一颗空树
        //2）它的左右两个子树的高度差的绝对值不超过1
        //3）左右子树都是一颗平衡二叉树
        if(root == null){
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int subb = leftDepth - rightDepth;
        return (subb <= 1 && subb >= -1) &&
                isBalanced(root.left) &&
                        isBalanced(root.right);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper_Sy(root.left,root.right);
    }

    private boolean helper_Sy(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        return helper_Sy(left.left,right.right) &&
                helper_Sy(left.right,right.left);
    }


}
