package Learnjava_21_0327;

import java.util.ArrayList;
import java.util.List;

//链接:https://leetcode-cn.com/problems/binary-tree-paths/
public class 二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        String curStr = "";
        DFS(root,list,curStr);
        return list;
    }
    public void DFS(TreeNode root, List<String> list, String curStr){
        if(root == null){
            return;
        }
        curStr += root.val;
        if(root.left == null && root.right == null){
            list.add(curStr);
        }else{
            DFS(root.left,list,curStr + "->");
            DFS(root.right,list,curStr + "->");
        }
    }
}
