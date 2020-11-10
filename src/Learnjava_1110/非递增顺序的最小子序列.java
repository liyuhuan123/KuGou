package Learnjava_1110;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//链接:https://leetcode-cn.com/problems/minimum-subsequence-in-non-increasing-order/
public class 非递增顺序的最小子序列 {
    public List<Integer> minSubsequence(int[] nums) {
        //定义此数组元素总和为sum
        //先排序,升序就从后往前遍历,降序就从前往后遍历,
        // 排序之后,从最大值向最小值的方向遍历,然后count进行累加,
        // 直到满足count>sum/2,
        //此时,前面的数之和大于剩下的元素之和
        int sum = Arrays.stream(nums).sum();
        int count = 0;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i = nums.length - 1;i >= 0;i--){
            list.add(nums[i]);
            count += nums[i];
            if(count * 2 > sum){
                return list;
            }
        }
        return list;
    }
}
