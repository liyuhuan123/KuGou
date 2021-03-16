package Learnjava_21_0316;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 按之字顺序打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int count = 0;
        while(!queue.isEmpty()){
            ++count;
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size > 0){
                TreeNode temp = queue.remove();
                list.add(temp.val);
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
                size--;
            }
            if(count % 2 == 0){
                ArrayList<Integer> temp = new ArrayList<>();
                int i = list.size() - 1;
                while(i >= 0){
                    temp.add(list.get(i));
                    i--;
                }
                result.add(temp);
            }else{
                result.add(list);
            }
        }
        return result;
    }
}
