package Learnjava_1003;

import java.util.HashSet;
import java.util.Set;
//链接：https://leetcode-cn.com/problems/distribute-candies/submissions/
public class 分糖果 {
    public int distributeCandies(int[] candies){
        Set<Integer> set = new HashSet<>();
        for(int temp : candies){
            set.add(temp);
        }
        return Math.min(set.size(),candies.length / 2);
    }
}
