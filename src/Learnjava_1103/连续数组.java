package Learnjava_1103;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/contiguous-array/
public class 连续数组 {
    //求含有相同0，1的最长连续子序列，将0换成-1，这样就是计算和为0的最长连续子序列的长度，如果和为0，长度等于i+1
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int ans = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            if(sum == 0){
                ans = i + 1;
            }
            if(map.get(sum) == null){
                map.put(sum,i);
                continue;
            }
            int temp = i - map.get(sum);
            if(temp > ans){
                ans = temp;
            }
        }
        return ans;
    }
}
