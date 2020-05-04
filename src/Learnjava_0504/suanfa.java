package Learnjava_0504;

import java.util.*;
class TreeNode{
    TreeNode root;
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class suanfa {
    public boolean isPalindrome(int x) {
//    if(x == 0 ||(x % 10 == 0 && x != 0)){
//        return false;
//    }
//    Queue<Integer> queue = new LinkedList<>();
//    int y = x;
//    while(y >= 0){
//        queue.offer(y % 10);
//        y /= 10;
//    }
//    String s = String.valueOf(x);
//    for(int i = 0;i < s.length();i++){
//        if(queue.poll() != s.charAt(i)){
//            return false;
//        }
//    }
//    return true;
        if (x < 0) {
            return false;
        }
        int help = 1;
        int tmp = x;
        while (tmp >= 10) {
            help *= 10;
            tmp /= 10;
        }
        while (x != 0) {
            if (x % 10 != x / help) {
                return false;
            }
            x = x % help / 10;
            help /= 100;
        }
        return true;
    }
    public int lengthOfLastWord(String s) {
        int count = 0;
        String[] str = s.split(" ");
        if(str.length != 0){
            count = str[str.length - 1].length();
        }
        return count;

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for(int i = m;i < m + n;i++){
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
    }
    public boolean isBalanced(TreeNode root) {
        //平衡二叉树：1.空树
        // 2.任何一个结点的左右子树都是平衡二叉树
        // 左右子树的高度相差不超过1
        if(root == null){
            return true;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        int sub = leftheight - rightheight;
        return (sub >= -1 && sub <= 1) && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper_height(root);
    }

    private int helper_height(TreeNode root) {
        int maxHeight = Math.max(helper_height(root.left),
                helper_height(root.right)) + 1;
        return maxHeight;
    }
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i = 1;i < s.length();i++){
            if(s.charAt(i) == ')' && stack.peek() == '('){
                stack.pop();
            }else if(s.charAt(i) == '}' && stack.peek() == '{'){
                stack.pop();
            }else if(s.charAt(i) == ']' && stack.peek() == '['){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();

    }

}
