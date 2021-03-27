package Learnjava_21_0327;
//链表:https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class 将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length - 1);
    }
    public TreeNode helper(int[] nums,int begin,int end){
        if(begin > end){
            return null;
        }
        int mid = (end + begin + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,begin,mid - 1);
        root.right = helper(nums,mid + 1,end);
        return root;
    }
}
