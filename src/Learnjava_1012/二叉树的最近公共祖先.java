package Learnjava_1012;
//链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class 二叉树的最近公共祖先 {
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q){
            return root;
        }
        boolean pInLeft = search(root.left,p);
        boolean qInLeft = search(root.left,q);
        if(pInLeft && qInLeft){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(!pInLeft && !qInLeft){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
    private boolean search(TreeNode root, TreeNode t){
        if(root == null){
            return false;
        }
        if(root == t){
            return true;
        }
        if(search(root.left,t)){
            return true;
        }
        return search(root.right,t);
    }
}
