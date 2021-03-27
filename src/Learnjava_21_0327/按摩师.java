package Learnjava_21_0327;
//链接:https://leetcode-cn.com/problems/the-masseuse-lcci/
public class 按摩师 {
    //动态规划:
    public int massage(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int f1 = 0;
        int f2 = 0;
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            res = Math.max(f1 + nums[i],f2);
            f1 = f2;
            f2 = res;
        }
        return res;
    }
}
