package Learnjava_1213;

import java.util.HashSet;
import java.util.Set;

public class 存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int e : nums){
            if(!set.add(e)){
                return true;
            }
        }
        return false;
    }
}
