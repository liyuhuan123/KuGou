package LearnJava_1116;
//链接:https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        if(nums.length <= 0 || nums == null){
            return 0;
        }
        int temp = nums[0];
        int result = nums[0];
        for(int i = 1;i < nums.length;i++){
            temp = helper(temp + nums[i],nums[i]);
            if(temp > result){
                result = temp;
            }
        }
        return result;
    }
    private int helper(int x,int y){
        return x > y ? x : y;
    }
}
