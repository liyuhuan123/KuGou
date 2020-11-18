package Learnjava_1118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 和为s的连续正数序列 {
    //用两个数字start和end分别表示序列的最小值和最大值,首先将start初始化为1,end初始化为2,
    //如果从start到end的和大于target,就从序列中去掉较小的值(增大start)
    //相反,只需要增大end
    //终止条件为:一直增加start到(1+target)/2并且end小于target为止
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(target < 3){
            int[][] ints = new int[][]{};
            return ints;
        }
        int start = 1;
        int end = 2;
        int mid = (1 + target) / 2;
        while(start < mid && end < target){
            int s = sum(start,end);
            if(s == target){
                list.add(helper(start,end));
                end++;
            }else if(s < target){
                end++;
            }else if(s > target){
                start++;
            }
        }
        int[][] arr = new int[list.size()][];
        for(int i = 0;i < list.size();i++){
            for(int j = 0;j < list.get(i).size();j++){
                arr[i][j] = list.get(i).get(j);
            }
        }
        return arr;
    }

    private List<Integer> helper(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for(int i = start;i <= end;i++){
            result.add(i);
        }
        return result;
    }

    private int sum(int start,int end){
        int count = 0;
        for(int i = start;i <= end;i++){
            count += i;
        }
        return count;
    }

    public static void main(String[] args) {
        和为s的连续正数序列 t = new 和为s的连续正数序列();
        System.out.println(Arrays.toString( t.findContinuousSequence(9)));
    }
}
