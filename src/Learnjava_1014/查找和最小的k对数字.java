package Learnjava_1014;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 查找和最小的k对数字 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> list1,List<Integer> list2){
                return list2.get(0) + list2.get(1) - list1.get(0) - list1.get(1);
            }
        });
        for(int i = 0;i < nums1.length;i++){
            if(queue.size() == k){
                List<Integer> temp = queue.peek();
                if(nums1[i] + nums2[0] > temp.get(0) + temp.get(1)){
                    break;
                }
            }
            for(int j = 0;j < nums2.length;j++){
                int sum = nums1[i] + nums2[j];
                List<Integer> list = queue.peek();
                if(queue.size() == k){
                    if(sum >= list.get(0) + list.get(1)){
                        break;
                    }
                }
                List<Integer> newList = new ArrayList<>();
                newList.add(nums1[i]);
                newList.add(nums2[j]);
                queue.offer(newList);
                if(queue.size() > k){
                    queue.poll();
                }

            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while(!queue.isEmpty()){
            result.add(queue.poll());
        }
        return result;
    }

}
