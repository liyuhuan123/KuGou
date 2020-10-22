package Learnjava_1022;
//https://leetcode-cn.com/problems/house-robber-ii/
public class 打家劫舍II {
    public int rob(int[] nums) {
        //动态规划：
        //因为首尾相连，所以首尾两家只能选择一个或者都不抢
        //把第一家和最后一家分别去掉，各算一遍能抢的最大值，取其中较大的那一个
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(rob(nums,0,nums.length - 1),rob(nums,1,nums.length));
    }
    private static int rob(int[] arr,int left,int right){
        int first = 0;
        int second = 0;
        int result = 0;
        for(int i = left;i < right;i++){
            result = Math.max(second,first + arr[i]);
            first = second;
            second = result;
        }
        return result;
    }
}
