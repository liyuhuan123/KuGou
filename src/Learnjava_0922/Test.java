package Learnjava_0922;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    //两个数组的交集
    // https://leetcode-cn.com/problems/intersection-of-two-arrays/
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length <= 0 || nums2.length <= 0){
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for(int i = 0,j = 0;i < nums1.length && j < nums2.length;){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums2[j] < nums1[i]){
                j++;
            }else{
                if(list.contains(nums1[i])){
                    i++;
                    j++;

                }else{
                    list.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0;i < res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
