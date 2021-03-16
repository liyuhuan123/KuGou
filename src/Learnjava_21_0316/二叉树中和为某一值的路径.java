package Learnjava_21_0316;

import java.util.ArrayList;

public class 二叉树中和为某一值的路径 {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public void DFS(TreeNode root,int target,int sum){
        if(root == null){
            return;
        }
        if(sum + root.val > target){
            return;
        }
        if(root.left == null && root.right == null){
            if(sum + root.val == target){
                path.add(root.val);
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        DFS(root.left,target,sum + root.val);
        DFS(root.right,target,sum + root.val);
        path.remove(path.size() - 1);
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        DFS(root,target,0);
        return result;
    }
}
