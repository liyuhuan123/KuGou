package Learnjava_0510;

import java.util.Scanner;
class TreeNode{
    TreeNode left;
    TreeNode right;
    TreeNode root;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            if(M > N){
                int temp = M;
                M = N;
                N = temp;
            }

            int count = isPrimNum(M,N);
            System.out.println();
        }
    }

    private static int isPrimNum(int m, int n) {
        int count = 0;
        while(m < n){
            int i;
            for(i = 2;i < Math.sqrt(m);i++){
                if(m % i == 0){
                    break;
                }
            }
            if(i == Math.sqrt(m)){
                count++;
            }
            m++;
        }
        return count;
    }
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null){
            return true;
        }
        return helper(pRoot.left,pRoot.right);

    }

    private boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left != null || right != null || left.val != right.val){
            return false;
        }
        return helper(left.left,right.right) &&
                helper(left.right,right.left);
    }
}
