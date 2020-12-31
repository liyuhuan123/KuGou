package Learnjava_1231;

import java.util.Arrays;
import java.util.Comparator;
//链接:https://leetcode-cn.com/problems/non-overlapping-intervals/
public class Main {
    //无重叠区间
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int current = intervals[0][1];
        for(int[] temp : intervals){
            if(temp[0] >= current){
                current = temp[1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
