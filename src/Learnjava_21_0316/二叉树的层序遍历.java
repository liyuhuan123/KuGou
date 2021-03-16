package Learnjava_21_0316;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的层序遍历 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(size > 0){
                TreeNode temp = queue.remove();
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
                list.add(temp.val);
                size--;
            }
            result.addAll(list);
        }
        return result;
    }
}
