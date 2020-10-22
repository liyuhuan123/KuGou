package Learnjava_1022;
//链接：https://leetcode-cn.com/problems/house-robber/
public class 打家劫舍I {
    public int rob(int[] nums) {
        //动态规划：
        //前n号房屋的金额=Math.max(n-1,n-2 + nums[i])
       if(nums == null || nums.length == 0){
           return 0;
       }
       int first = 0;
       int second = 0;
       int rob = 0;
       for(int i = 0;i < nums.length;i++){
           rob = Math.max(second,first + nums[i]);
           first = second;
           second = rob;
       }
       return rob;
    }
}
