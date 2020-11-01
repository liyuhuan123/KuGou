package Learnjava_1101;
//链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class 树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }
        boolean result = false;
        if(A.val == B.val){
            result = helper(A,B);
        }
        if(!result){
            return isSubStructure(A.left,B) || isSubStructure(A.right,B);
        }else{
            return true;
        }

    }
    private boolean helper(TreeNode A,TreeNode B){
        if(B == null){
            return true;
        }
        if(A == null){
            return false;
        }
        if(A.val != B.val){
            return false;
        }
        return helper(A.left,B.left) && helper(A.right,B.right);
    }

}
