package Learnjava_21_0118;
//链接:https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&&tqId=11192&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
public class 平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root) {
         if(root == null){
             return true;
         }
         int leftDepth = TreeDepth(root.left);
         int rightDepth = TreeDepth(root.right);
         int sub = leftDepth - rightDepth;
         return (sub <= 1 && sub >= -1) && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}
