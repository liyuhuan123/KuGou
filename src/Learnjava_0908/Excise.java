package Learnjava_0908;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Excise {
    //前K个高频元素
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(Integer temp : map.keySet()){
            if(queue.size() < k){
                queue.add(temp);
            }else if(map.get(temp) > map.get(queue.peek())){
                queue.poll();
                queue.add(temp);
            }
        }
        int[] arr = new int[k];
        int i = 0;
        while(!queue.isEmpty()){
            arr[i] = queue.poll();
            i++;
        }
        return arr;
    }
}
