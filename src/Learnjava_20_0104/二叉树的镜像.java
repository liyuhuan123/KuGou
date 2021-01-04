package Learnjava_20_0104;
//链接:https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=188&&tqId=37042&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class 二叉树的镜像 {
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        Mirror(root.left);
        Mirror(root.right);
    }
}
