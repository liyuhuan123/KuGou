package Learnjava_1113;

import java.util.ArrayList;
import java.util.List;

//链接:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class 二叉搜索树的第K大结点 {
    public int kthLargest(TreeNode root, int k) {
        //中序遍历的倒数第k个结点就是第k大的结点
        List<Integer> list = new ArrayList<>();;
        inOrder(root,list);
        return list.get(list.size() - k);
    }
    private void inOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
