package Learnjava_1008;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Tree {
    //找到了返回true，找不到返回false
    public static boolean contains1(TreeNode root, int val){
        if(root == null){
            return false;
        }
        if(root.val == val){
            return true;
        }
        boolean leftContains = contains1(root.left,val);
        if(leftContains){
            return true;
        }
        return contains1(root.right,val);
    }
    //1.在树中找到val了，返回第一个人遇到的val所在的结点
    //2.如果没找到，返回null
    public static TreeNode contains2(TreeNode root,int val){
        if(root == null){
            //返回没有找到
            return null;
        }
        if(root.val == val){
            return root;//返回根结点
        }
        TreeNode leftContains = contains2(root.left,val);
        //如何根据leftContains判断是否找到了val，
        //leftContains == null 没找到
        //leftContains != null 找到了
        if(leftContains != null){
            //在root为根的树的左子树中，找到了val
            return leftContains;
        }
        //左子树没有找到
        return contains2(root.right,val);
    }
    //在以root为根的二叉树中，找node结点
    public static boolean contains3(TreeNode root,TreeNode node){
        if(root == null){
            return false;
        }
        if(node == root){
            return true;
        }
        boolean leftContains = contains3(root.left,node);
        if(leftContains){
            return true;
        }
        return contains3(root.right,node);
    }
}
