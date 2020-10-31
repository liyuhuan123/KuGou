package Learnjava_1031;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class 从上到下打印二叉树 {
    //请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
    // 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            result.add(new ArrayList<>());
            int size = queue.size();
            while(size > 0){
                TreeNode current = queue.poll();
                list.add(current.val);
                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
                size--;
            }
            if(level % 2 == 0 || level == 0){
                result.get(level).addAll(list);
            }else{
                for(int i = list.size() - 1;i >= 0;i--){
                    result.get(level).add(list.get(i));
                }
            }
            level++;
        }
        return result;
        }
}
