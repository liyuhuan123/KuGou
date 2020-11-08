package Learnjava_1108;

import java.util.HashSet;
import java.util.Set;

//https://leetcode-cn.com/problems/contains-duplicate/
public class 存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int temp : nums){
            if(!set.add(temp)){
                return true;
            }
        }
        return false;
    }
}
