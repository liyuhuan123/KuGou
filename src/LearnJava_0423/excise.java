package LearnJava_0423;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class excise {
    public List<Integer> preorderTraversal(TreeNode root) {
        //二叉树的前序遍历（根左右）
        List<Integer> resultList = new ArrayList<>();
        return preorderTraversal(root,resultList);
    }
    public List<Integer> preorderTraversal
            (TreeNode root, List<Integer> resultList){
        if(root == null){
            return resultList;
        }
        resultList.add(root.val);
        preorderTraversal(root.left,resultList);
        preorderTraversal(root.right,resultList);
        return resultList;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return inorderTraversal(root,result);
    }
    public List<Integer> inorderTraversal
            (TreeNode root,List<Integer> result){
        if(root == null){
            return result;
        }
        inorderTraversal(root.left,result);
        result.add(root.val);
        inorderTraversal(root.right,result);
        return result;
    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) &&
                isSameTree(p.right,q.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return help(s,t);
    }
    public boolean help(TreeNode s,TreeNode t){
        return s != null && (isSameTree(s,t) ||
                help(s.left,t) ||
                help(s.right,t));
    }
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            int max = maxNumber(root);
            return max;
        }
    }
    public int maxNumber(TreeNode root){
        if(root == null){
            return 0;
        }
        int max = Math.max(maxNumber(root.left),
                maxNumber(root.right)) + 1;
        return max;
    }

}
