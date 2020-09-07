package Learnjava_0907;


import java.util.*;

public class Main {
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
            int[] res = new int[k];
            int index = 0;
            while(!queue.isEmpty()){
                res[index] = queue.poll();
                index++;
            }
            return res;
        }

    }
