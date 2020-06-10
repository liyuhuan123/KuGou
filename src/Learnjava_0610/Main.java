package Learnjava_0610;

import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Main {
    //修剪二叉搜索树
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return null;
        }
        if(root.val < L){
            root = trimBST(root.right,L,R);
        }else if(root.val > R){
            root = trimBST(root.left,L,R);
        }else{
            root.left = trimBST(root.left,L,R);
            root.right = trimBST(root.right,L,R);
        }
        return root;
    }
    //回文数
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int y = x;
        int result = 0;
        while(x != 0){
            int n = x %10;
            result *= 10 + n;
            n /= 10;
        }
        return result == y;
    }
    //栈的最小值
    Stack<Integer> stack;
    Stack<Integer> minstack;
    int min = Integer.MAX_VALUE;
    public void MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(x <= min){
            minstack.push(x);
            min = x;
        }
    }

    public void pop() {
        if(minstack.peek().equals(stack.pop())){
            minstack.pop();
            if(!minstack.empty()){
                min = minstack.peek();
            }else{
                min = Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        return stack.empty() ? 0 : stack.peek();
    }

    public int getMin() {
        return minstack.empty() ? 0 : minstack.peek();
    }
}
