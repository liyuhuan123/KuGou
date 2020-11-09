package Learnjava_1109;

import java.util.ArrayList;
import java.util.List;
//链接:https://www.nowcoder.com/practice/a9fec6c46a684ad5a3abd4e365a9d362?tpId=188&tqId=36321&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}
public class 实现二叉树的先序中序和后序遍历 {
    private List<Integer> list = new ArrayList<>();
    public int[][] threeOrders (TreeNode root) {
        // write code here
        int n = countNodes(root);
        int[][] result = new int[3][n];
        preOrder(root);
        inOrder(root);
        postOrder(root);
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < n;j++){
                result[i][j] = list.get( i * n + j);
            }
        }
        return result;
    }
    private void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);

    }
    private void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);

    }
    public int countNodes(TreeNode node){
        if(node==null){
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}
