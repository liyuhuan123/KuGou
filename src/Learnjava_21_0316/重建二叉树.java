package Learnjava_21_0316;
//链接:https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class 重建二叉树 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length != in.length){
            return null;
        }
        return helper(pre,0,pre.length - 1,in,0,in.length -1);
    }
    public TreeNode helper(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for(int i = inStart;i <= inEnd;i++){
            if(in[i] == pre[preStart]){
                root.left = helper(pre,preStart + 1,preStart + i - inStart,in,inStart,i - 1);
                root.right = helper(pre,preStart + i - inStart + 1,preEnd,in,i + 1,inEnd);

            }
        }
        return root;
    }
}
