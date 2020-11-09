package Learnjava_1109;

//https://leetcode-cn.com/problems/non-overlapping-intervals/
import java.util.Arrays;
import java.util.Comparator;

public class 无重叠区间 {
    //每次选取和上次区间不重复的结束最早的区间,选取最先结束的区间,
    //并删除与该区间重复的区间
    //选取最先结束的区间:将区间以end升序排序删除与该区间重复的区间,
    //每次选取时判断区间的 start >= end
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
        int end = intervals[0][1];
        for(int[] temp : intervals){
            if(temp[0] >= end){
                end = temp[1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
