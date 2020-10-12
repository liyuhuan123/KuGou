package Learnjava_1012;
//链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree/
public class 根据二叉树构建字符串 {
    public class TreeNode{
        TreeNode right;
        TreeNode left;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public String tree2str(TreeNode t) {
        if(t == null){
            return "";
        }
        StringBuilder result = new StringBuilder();
        preOrder(result,t);
        return result.toString();
    }
    private void preOrder(StringBuilder result,TreeNode root){
        if(root != null){
            result.append(root.val);
            if(root.left == null && root.right == null){
                return;
            }else if(root.left != null && root.right == null){
                result.append("(");
                preOrder(result,root.left);
                result.append(")");
            }else if(root.left == null && root.right != null){
                result.append("(");
                result.append(")");
                result.append("(");
                preOrder(result,root.right);
                result.append(")");
            }else if(root.left != null && root.right != null){
                result.append("(");
                preOrder(result,root.left);
                result.append(")");
                result.append("(");
                preOrder(result,root.right);
                result.append(")");
            }
        }
    }
}
