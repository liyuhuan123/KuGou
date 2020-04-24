package LearnJava_0424;

import java.util.Scanner;

public class revier_tree_high {
    //编一个程序，读入用户输入的一串先序遍历字符串，
    // 根据此字符串建立一个二叉树
    //输出中序遍历结果
    static class TreeNode{
        public char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //输入字符串
            String line = scanner.next();
            //1）创建树
            TreeNode root = build(line);
            //2）中序遍历
            inOrder(root);
            System.out.println();
        }
    }

    private static void inOrder(TreeNode root) {
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    //记录当前访问到line中的哪个元素了
    private static int index = 0;
    private static TreeNode build(String line) {
        index = 0;
        //通过下面的方法辅助完成
        return createTreePreOrder(line);
    }

    private static TreeNode createTreePreOrder(String line) {
        //获取到当前处理到哪个节点了
        char cur = line.charAt(index);
        if(cur == '#'){
            return null;
        }
        TreeNode root = new TreeNode(cur);
        index++;//准备处理下一个节点,写一个节点就是当前root左子树先序遍历结果
        root.left = createTreePreOrder(line);
        index++;
        root.right = createTreePreOrder(line);
        return root;
    }
}
