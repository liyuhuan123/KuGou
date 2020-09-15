package Learnjava_0915;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Main {
    //矩阵对角线元素的和
    // https://leetcode-cn.com/problems/matrix-diagonal-sum/
    public int diagonalSum(int[][] mat) {
        int res = 0;
        int temp = 0;
        for(int i = 0;i < mat.length;i++){
            for(int j = 0;j < mat[i].length;j++){
                if((i + j) == mat.length - 1){
                    res += mat[i][i];
                    res += mat[i][j];
                    if(i == j){
                        temp = mat[i][j];
                    }
                }
            }
        }
        return res - temp;
    }
    //删除链表中的结点
    // https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }
    //按既定顺序创建目标数组
    // https://leetcode-cn.com/problems/create-target-array-in-the-given-order/

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < index.length;i++){
            list.add(index[i],nums[i]);
        }
        int[] res = new int[list.size()];
        for(int i = 0;i < list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    //解压缩编码列表
    //https://leetcode-cn.com/problems/decompress-run-length-encoded-list/
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length - 1;i += 2){
            int j = i + 1;
            for(int k = 0;k < nums[i];k++){
                list.add(nums[j]);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
    //二进制链表转整数
    public int getDecimalValue(ListNode head) {
       ListNode cur = head;
       int res = 0;
       while(cur != null){
           res = res * 2 + cur.val;
           cur = cur.next;
       }
       return res;
    }
}
