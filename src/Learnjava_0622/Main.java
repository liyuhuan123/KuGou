package Learnjava_0622;
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
//二叉树展开为链表
public class Main {
    public void flatten(TreeNode root) {
        while(root != null){
            if(root.left == null){
                root = root.right;
            }else{
                TreeNode pre = root.left;
                while(pre.right != null){
                    pre = pre.right;
                    pre.right = root.right;
                    root.right = root.left;
                    root.left = null;
                    root = root.right;
                }
            }
        }
    }
}
