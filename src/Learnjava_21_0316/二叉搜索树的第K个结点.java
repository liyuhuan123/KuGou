package Learnjava_21_0316;

import java.util.ArrayList;

public class 二叉搜索树的第K个结点 {
    ArrayList<TreeNode> list = new ArrayList<>();
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null){
            return null;
        }
        inOrder(pRoot);
        if(k <= 0 || k > list.size()){
            return null;
        }else{
            return list.get(k - 1);
        }
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }
}
