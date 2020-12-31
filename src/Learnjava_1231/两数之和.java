package Learnjava_1231;

import java.util.HashMap;
import java.util.Map;
//链接:https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=188&&tqId=37022&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
public class 两数之和 {
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < numbers.length;i++){
            map.put(numbers[i],i + 1);
        }
        int start = 1;
        Integer end = null;
        for(int i = 0;i < numbers.length;i++){
            start = i+1;
            int endValue = target - numbers[i];
            end = map.get(endValue);
            if(end==null){
                continue;
            }
            if(end <= start) {
                continue;
            }

            break;
        }
        return new int[] {start,end};
    }
}
