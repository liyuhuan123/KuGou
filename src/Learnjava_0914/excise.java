package Learnjava_0914;
public class excise {
    //一维数组的动态和
    // https://leetcode-cn.com/problems/running-sum-of-1d-array/
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            res[i] = sum + nums[i];
            sum += nums[i];
        }
        return res;
    }
    //删除中间结点
    // https://leetcode-cn.com/problems/delete-middle-node-lcci/
    public void deleteNode(ListNode node){
         node.val = node.next.val;
         node.next = node.next.next;
    }
    //访问所有点最短时间
}
