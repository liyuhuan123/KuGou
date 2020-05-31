package Learnjava_0531;

import java.util.Scanner;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class main {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return  true;
        }
        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return helper(left.left,right.right) &&
                helper(left.right,right.left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int count = 0;
            for(int i = 0;i < str1.length();i++){
                StringBuilder result = new StringBuilder(str1);
                result.insert(i,str2);
                if(ishuiwen(result.toString())){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean ishuiwen(String str) {
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
