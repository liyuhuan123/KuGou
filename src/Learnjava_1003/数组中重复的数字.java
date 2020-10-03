package Learnjava_1003;

import java.util.HashSet;
import java.util.Set;
//链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
public class 数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean flag = false;
        int result = 0;
        for(int temp : nums){
            flag = set.add(temp);
            if(!flag){
                result = temp;
                break;
            }
        }
        return result;
    }
}
