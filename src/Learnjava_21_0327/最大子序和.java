package Learnjava_21_0327;

import java.util.ArrayList;

//链接:https://leetcode-cn.com/problems/maximum-subarray/
public class 最大子序和 {
    //动态规划
    public int maxSubArray(int[] nums) {
        if(nums.length <= 0)
            return 0;
        int res = nums[0];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1;i < nums.length;i++){
            list.add(Math.max(list.get(i - 1) + nums[i],nums[i]));
            res = Math.max(list.get(i),res);
        }
        return res;
    }
}
