package Learnjava_1011;


import java.util.ArrayList;
import java.util.List;
//https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class 从中序与后续遍历构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> inList = arrayToList(inorder);
        List<Integer> postList = arrayToList(postorder);
        return creatTree(inList,postList);
    }

    private TreeNode creatTree(List<Integer> inList, List<Integer> postList) {
        if(inList.isEmpty() || postList.isEmpty()){
            return null;
        }
        int rootVal = postList.get(postList.size() - 1);
        TreeNode root = new TreeNode(rootVal);
        if(postList.size() == 1 || inList.size() == 1){
            return root;
        }
        int rootSize = inList.indexOf(rootVal);
        List<Integer> leftIn = inList.subList(0,rootSize);
        List<Integer> rightIn = inList.subList(rootSize + 1,inList.size());
        List<Integer> leftPost = postList.subList(0,rootSize);
        List<Integer> rightPost = postList.subList(rootSize + 1,postList.size());
        root.left = creatTree(leftIn,leftPost);
        root.right = creatTree(rightIn,rightPost);
        return root;

    }

    private List<Integer> arrayToList(int[] postorder) {
        List<Integer> result = new ArrayList<>();
        for(int e : postorder){
            result.add(e);
        }
        return result;
    }
}
