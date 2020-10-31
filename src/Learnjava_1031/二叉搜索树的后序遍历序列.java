package Learnjava_1031;
//链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
public class 二叉搜索树的后序遍历序列 {
    //思路：
    //1.二叉搜索树：树的左节点小于根结点，右节点大于根结点
    //2.后序遍历：遍历的末结点是树的根结点
    //3.由末结点分开左子树和右子树两部分，再判断右子树是否全部大于根结点
    //是则递归判断左子树和右子树两部分是否符合二叉搜索树
    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null || postorder.length == 0){
            return true;
        }
        return helper(postorder,0,postorder.length - 1);
    }
    private static boolean helper(int[] arr,int start,int end){
        if(start >= end){
            return true;
        }
        int root = arr[end];
        int i = 0;
        for(;i < end;i++){
            if(arr[i] > root){
                break;
            }
        }
        int j = i;
        for(;j < end;j++){
            if(arr[j] < root){
                return false;
            }
        }
        boolean left = true;
        if(i > start){
            left = helper(arr,start,i - 1);
        }
        boolean right = true;
        if(i < end){
            right = helper(arr,i,end - 1);
        }
        return left && right;
    }

}
