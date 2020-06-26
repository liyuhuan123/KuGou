package Learnjava_0626;

import java.util.Scanner;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Main {
    public static void main(String[] args) {
        //数字分类
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            int[] array = new int[N];
            for(int i = 0;i < N;i++){
                array[i] = sc.nextInt();
            }
            helper(array,N);
        }

    }

    private static void helper(int[] array,int N) {
        int A1 = 0;
        int A2 = 0;
        int A3 = 0;
        double A4 = 0;
        int A5 = 0;
        int temp = 1;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0;i < N;i++){
            if(array[i] % 5 == 0 && array[i] % 2 == 0){
                A1 += array[i];
            }
            if(array[i] % 5 == 1){
                A2 += array[i] * temp;
                temp *= -1;
                count1++;
            }
            if(array[i] % 5 == 2){
                A3++;
            }
            if(array[i] % 5 == 3){
                A4 += array[i];
                count2++;
            }
            if(array[i] % 5 == 4){
                if(A5 < array[i]){
                    A5 = array[i];
                }
            }
        }
        if(A1 != 0){
            System.out.print(A1 + " ");
        }else{
            System.out.print(N + " ");
        }
        if(count1 != 0){
            System.out.print(A2 + " ");
        }else{
            System.out.print(N + " ");
        }
        if(A3 != 0){
            System.out.print(A3 + " ");
        }else{
            System.out.print(N + " ");
        }
        if(A4 != 0){
            System.out.printf("%.1f",(A4 / count2));
            System.out.print(" ");
        }else{
            System.out.print(N + " ");
        }
        if(A5 != 0){
            System.out.println(A5);
        }else{
            System.out.println(N);
        }

    }

    //二叉树的平衡性检查
    public boolean isBalance(TreeNode root) {
        // write code here
        if(root == null){
            return true;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(Math.abs(left - right) > 1){
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
    private int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
