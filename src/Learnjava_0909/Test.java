package Learnjava_0909;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
TreeNode(int x) { val = x; }
}


public class Test {
    //从上到下打印二叉树
    // https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
    public int[] levelOrder(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.offer(root);
        while(queue.size() > 0){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        int[] arr = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
