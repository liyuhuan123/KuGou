package Learnjava_21_0327;
//链接:https://leetcode-cn.com/problems/increasing-order-search-tree/
import java.util.ArrayList;
public class 递增顺序查找树 {
    public ArrayList<TreeNode> list = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        inOrderTree(root);
        for(int i = 0;i < list.size() - 1;i++){
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
        return list.get(0);
    }
    public void inOrderTree(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTree(root.left);
        list.add(root);
        inOrderTree(root.right);
    }
}
