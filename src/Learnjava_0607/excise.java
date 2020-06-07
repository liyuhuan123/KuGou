package Learnjava_0607;
class TreeNode {
    int val;
    TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
//二叉树的堂兄弟结点
public class excise {
    public static void main(String[] args) {

    }
    private TreeNode node = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        int temp1 = getDepth(root,x);
        TreeNode nodeX = node;
        int temp2 = getDepth(root,y);
        TreeNode nodeY = node;
        return temp1 == temp2 && nodeX != nodeY;
    }

    private int getDepth(TreeNode root, int x) {
        if(root == null){
            return Integer.MIN_VALUE;
        }else if(root.val == x){
            return 0;
        }
        int left = getDepth(root.left,x);
        int right = getDepth(root.right,x);
        if(left == 0 || right == 0){
            node = root;}
            return Math.max(left,right) + 1;

    }
    //二叉树的直径
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        max = Math.max(leftDepth + rightDepth,max);
        return Math.max(leftDepth,rightDepth) + 1;
    }
    //给定一个二叉搜索树（Binary Search Tree），
    // 把它转换成为累加树（Greater Tree)，
    // 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

    public TreeNode convertBST(TreeNode root) {
        change(root,0);
        return root;
    }

    private int change(TreeNode root, int rightSum) {
        if(root == null){
            return rightSum;
        }
        rightSum = change(root.right,rightSum);
        root.val += rightSum;
        rightSum = root.val;
        rightSum = change(root.left,rightSum);
        return rightSum;
    }
}
