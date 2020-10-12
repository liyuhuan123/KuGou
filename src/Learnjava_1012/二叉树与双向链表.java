package Learnjava_1012;

//链接：https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&&tqId=11179&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
public class 二叉树与双向链表 {
    public static class TreeNode{
        TreeNode right;
        TreeNode left;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private TreeNode head;//链表头结点
    private TreeNode last;//链表当前的 最后一个结点

    public TreeNode Convert(TreeNode pRootOfTree) {
        head = last = null;
        inorder(pRootOfTree);
        return head;
    }
    private void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            add(root);
            inorder(root.right);
        }
    }
    private void add(TreeNode root){
        TreeNode newNode = new TreeNode(root.val);
        if(last == null){
            head = newNode;
        }else{
            last.right = newNode;
        }
        newNode.left = last;
        last = newNode;
    }
}
