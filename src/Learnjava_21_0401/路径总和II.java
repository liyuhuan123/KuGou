package Learnjava_21_0401;

import java.util.ArrayList;
import java.util.List;
//链接:https://leetcode-cn.com/problems/path-sum-ii/
public class 路径总和II {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return res;
        }
        DFS(root,res,targetSum,list);
        return res;
    }
    public void DFS(TreeNode root, List<List<Integer>> res, int targetSum, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(targetSum == root.val && root.left == null && root.right == null){
            res.add(list);
        }else{
            List<Integer> temp = new ArrayList<>(list);
            DFS(root.left,res,targetSum - root.val,list);
            DFS(root.right,res,targetSum - root.val,temp);
        }
    }
}
