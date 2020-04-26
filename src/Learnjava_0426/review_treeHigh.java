package Learnjava_0426;

import java.util.LinkedList;
import java.util.Queue;

public class review_treeHigh {
    static class TreeNode{
        int val;
        TreeNode root;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private void levalOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur =  queue.poll();
            System.out.print(cur.val);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
    private static boolean completeTree(TreeNode root){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean temp = false;
        if(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            while (!temp) {

                if (cur.left != null && cur.right != null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left != null && cur.right == null){
                    temp = true;
                    queue.offer(cur.left);
                }else if(cur.left == null && cur.right == null){
                    return false;
                }else{
                    temp = true;
                }
            }
            if(cur.left != null || cur.right != null){
                return false;
            }
        }
        return true;
    }
}
