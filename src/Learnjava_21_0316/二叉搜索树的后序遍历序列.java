package Learnjava_21_0316;

public class 二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return helper(sequence,0,sequence.length - 1);
    }
    public boolean helper(int[] sequence,int start,int root){
        if(start >= root)return true;
        int i = start;
        for(;i < root;i++){
            if(sequence[i] > sequence[root]){
                break;
            }
        }
        for(int j = i;j < root;j++){
            if(sequence[j] < sequence[root]){
                return false;
            }
        }
        return helper(sequence,start,i - 1) && helper(sequence,i,root - 1);
    }
}
