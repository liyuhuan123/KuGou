package Learnjava_1024;

import java.util.Arrays;

public class 数组中出现的次数II {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 1){
            return nums[0];
        }
        for(int i = 0;i < nums.length -3;){
            if(nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]){
                i += 3;
            }else{
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
