package Learnjava_1011;

import java.util.Scanner;
//二叉树遍历
// 链接：https://www.nowcoder.com/practice/4b91205483694f449f94c179883c1fef?tpId=60&&tqId=29483&rp=1&ru=/activity/oj&qru=/ta/tsing-kaoyan/question-ranking
class TreeNode{
    TreeNode left;
    TreeNode right;
    char val;

    public TreeNode(char val) {
        this.val = val;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String line = sc.nextLine();
            inOrder(creatTree(line));
            System.out.println();
        }
    }
    private static int index = 0;
    private static TreeNode creatTree(String line){
        char temp = line.charAt(index);
        if(temp == '#'){
            return null;
        }
        TreeNode cur = new TreeNode(temp);
        index++;
        cur.left = creatTree(line);
        index++;
        cur.right = creatTree(line);
        return cur;


    }
    private static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}
