package Learnjava_0927;

import java.util.HashMap;
import java.util.Map;

public class 数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map =  new HashMap<>();
        int length = nums.length;
        for(int i = 0;i < length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i]) + 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > length / 2){
                return entry.getKey();
            }
        }
        return 0;
    }
}
