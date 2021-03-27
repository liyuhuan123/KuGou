package Learnjava_21_0327;

import java.util.ArrayList;
import java.util.List;

//链接:https://leetcode-cn.com/problems/path-sum/
public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        int curSum = 0;
        DFS(root,list,curSum);
        for(int i = 0;i < list.size();i++){
            if(list.get(i) == targetSum){
                return true;
            }
        }
        return false;
    }
    public void DFS(TreeNode root, List<Integer> list, int curSum){
        if(root == null){
            return;
        }
        curSum += root.val;
        if(root.left == null && root.right == null){
            list.add(curSum);
        }else{
            DFS(root.left,list,curSum);
            DFS(root.right,list,curSum);
        }
    }
}
