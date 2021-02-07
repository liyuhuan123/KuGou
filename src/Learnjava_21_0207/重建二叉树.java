package Learnjava_21_0207;
//链接:https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class 重建二叉树 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length != in.length){
            return null;
        }
        return helper(pre,0,pre.length - 1,in,0,in.length - 1);
    }
    private TreeNode helper(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for(int i = inStart;i <= inEnd;i++){
            if(pre[preStart] == in[i]){
                root.left = helper(pre,preStart + 1,preStart+i-inStart,in,inStart,i - 1);
                root.right = helper(pre,preStart+i-inStart + 1,preEnd,in,i+1,inEnd);
            }
        }
        return root;
    }
}
