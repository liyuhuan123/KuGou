package Learnjava_21_0227;
//链接:https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class N叉树层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root != null)
            queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        while(!queue.isEmpty()){
            //判断当前队列中元素的个数
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            while(size-- != 0){
                Node cur = queue.poll();
                row.add(cur.val);
                //孩子入队
                for(Node ch : cur.children){
                    queue.offer(ch);
                }
            }
            //同一行的元素存入结果中
            if(!row.isEmpty()){
                list.add(row);
            }
        }
        return list;
    }
}
