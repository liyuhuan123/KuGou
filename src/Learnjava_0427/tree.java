package Learnjava_0427;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode root;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class tree{
    private static void levelOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.val);
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
    private static boolean iscompletetree(TreeNode root){
        if(root == null ||
                (root.left == null && root.right == null)){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean temp = false;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            while (!temp) {
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    return false;
                } else if (cur.left == null && cur.right == null) {
                    temp = true;
                }else{
                    temp = true;
                    queue.offer(cur.left);
                }
            }
            if(cur.left != null || cur.right != null){
                return false;
            }
        }
        return true;

    }
    //编一个程序，读入用户输入的一串先序遍历字符串，
    // 根据此字符串建立一个二叉树（以指针方式存储）。
    // 例如如下的先序遍历字符串：
    // ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。
    // 建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。

    public static void main(String[] args) {
//        TreeNode tree = new TreeNode(1);
//        tree.left = new TreeNode(2);
//        tree.right = new TreeNode(3);
//        tree.left.left = new TreeNode(4);
//        tree.left.right = new TreeNode(5);
//        tree.left.left.right = new TreeNode(6);
////        levelOrderTraversal(tree);
//        System.out.println(iscompletetree(tree));
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.next();
            TreeNode root = build(line);
            inorderTree(root);
            System.out.println();
        }
    }

    private static void inorderTree(TreeNode root) {
        if(root == null){
            return;
        }
        inorderTree(root.left);
        System.out.print(root.val + " ");
        inorderTree(root.right);
    }
    private static int index = 0;
    private static TreeNode build(String line) {
        index = 0;
        return helper_build(line);
    }

    private static TreeNode helper_build(String line) {
        char cur = line.charAt(index);
        if(cur == '#'){
            return null;
        }
        TreeNode root = new TreeNode(cur);
        index++;
        helper_build(line);
        index++;
        helper_build(line);
        return root;
    }
}