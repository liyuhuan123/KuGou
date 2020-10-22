package Learnjava_1022;
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
//链接：https://leetcode-cn.com/problems/house-robber-iii/
public class 打家劫舍III {
    public int rob(TreeNode root) {
        //二叉树的后续遍历
        //动态规划
        //使用一个有两个元素的数组result来记录抢到的金额
        //result[0],result[1]分别代表不包含根结点与包含根结点的金额
        //相比取最大值
        if(root == null){
            return 0;
        }
        int[] result = helperRob(root);
        return Math.max(result[0],result[1]);
    }
    private static int[] helperRob(TreeNode root){
        int[] result = new int[2];
        if(root == null){
            return result;
        }
        //左子树 不包含根结点与包含根结点

        int[] left = helperRob(root.left);
        int[] right = helperRob(root.right);
        //不包含根节点
        result[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        //包含根节点
        result[1] = left[0] + right[0] + root.val;
        return result;
    }
}
