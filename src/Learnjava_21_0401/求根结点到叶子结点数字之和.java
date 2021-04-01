package Learnjava_21_0401;
//链接:https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
public class 求根结点到叶子结点数字之和 {
    public int res = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val;
        }
        DFS(root,0);
        return res;
    }
    public void DFS(TreeNode root,int curRes){
        curRes = curRes * 10 + root.val;
        if(root.left != null){
            DFS(root.left,curRes);
        }
        if(root.right != null){
            DFS(root.right,curRes);
        }
        if(root.left == null && root.right == null){
            res += curRes;
        }
    }
}
