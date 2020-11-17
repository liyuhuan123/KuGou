package Learnjava_1117;

//链接:https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
public class 和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int temp = nums[left] + nums[right];
            if(temp < target){
                left++;
            }else if(temp > target){
                right--;
            }else{
                return new int[]{nums[left],nums[right]};
            }
        }
        return new int[0];
    }
}
