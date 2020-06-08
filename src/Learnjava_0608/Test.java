package Learnjava_0608;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
public class Test {
    static int cnt = 6;

    static{
        cnt += 9;
    }
    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
    //二叉树的坡度
    int result = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return result;
    }
    public  int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int temp = left > right ? left - right : right - left;
        result = result + temp;
        return left + right + root.val;
    }
    //单值二叉树
    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left != null && root.left.val != root.val){
            return false;
        }
        if(root.right != null && root.right.val != root.val){
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
