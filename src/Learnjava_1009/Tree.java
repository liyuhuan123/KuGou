package Learnjava_1009;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Tree {
    //二叉树的层序遍历
    private static void levelTravelsal(TreeNode root){
        //队列的元素类型是树的结点
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //目前的这份流程中，不会出现把null放到队列中的情况
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            System.out.println(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }

    }
    //判断一棵树是不是完全二叉树
    //利用层序遍历，分析完全二叉树和非完全二叉树的区别
    //
    private static boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(true){
            //所以代码根本没有考虑queue.empty()的情况
            TreeNode node = queue.remove();
            if(node == null){
                break;
            }
            //不需要打印
            //直接把左右孩子拖入队列中（不管是不是null）
            queue.add(node.left);
            queue.add(node.right);
        }
        //检查队列中，是不是全是null
        while(queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node == null){
                //一个结点为null,不能说明是完全二叉树
                continue;
            }else{
                //一个结点不为null，可以说明不是完全二叉树
                return false;
            }
        }
        return true;
    }
    static class NL{
        TreeNode node;
        int level;

        public NL(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public static void levelOrderWithLevel(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<NL> queue = new LinkedList<>();
        queue.add(new NL(root, 1));

        while (!queue.isEmpty()) {
            NL nl = queue.remove();
            TreeNode node = nl.node;
            int level = nl.level;

            System.out.println(level);
            System.out.println(node.val);

            if (node.left != null) {
                queue.add(new NL(node.left, level + 1));
            }

            if (node.right != null) {
                queue.add(new NL(node.right, level + 1));
            }
        }
    }

    //https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
    //二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return list;
        }
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            list.add(new ArrayList<>());
            int size = queue.size();
            for(int i = 0;i < size;i++){
                TreeNode temp = queue.remove();
                list.get(level).add(temp.val);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            level++;
        }
        return list;
    }
}
