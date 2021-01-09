package Learnjava_21_0109;
//链接:https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
import java.util.ArrayList;

public class 和为s的连续正数序列 {
    //方法1:暴力解法
    //双层循环,找出所有和为S的连续正数序列
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> result = new ArrayList<>();
        for(int i = 1;i < target;i++){
            int sum = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = i;j < target;j++){
                if(sum < target){
                    sum += j;
                    temp.add(j);
                    if(sum == target){
                        int[] arr = new int[temp.size()];
                        for(int k = 0;k < temp.size();k++){
                            arr[k] = temp.get(k);
                        }
                        result.add(arr);
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    //方法2:设置一大一小两个指针
    //1.初始状态下,small指向1,big指向2,如果从small到big的和大于target,则从序列中去掉较小的值
    //2.也就是small向后移一个位置,若从small到big的序列和小于target则big向后移动一个位置,以便序列包含更多的数字
    //3.因为题目中要求最少是两个数字,所以small最大为(target+1)/2
    public int[][] findContinuousSequence2(int target) {
        ArrayList<int[]> result = new ArrayList<>();
        if(target <= 1){
            return result.toArray(new int[result.size()][]);
        }
        int small = 1;
        int big = 2;
        while(small != (1 + target) / 2){
            int curSum = helper(small,big);
            if(curSum == target){
                int[] temp = new int[big - small + 1];
                int k = 0;
                for(int i = small;i <= big;i++){
                    temp[k++] = i;
                }
                result.add(temp);
                small++;
                big++;
            }else if(curSum < target){
                big++;
            }else{
                small++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    private int helper(int small, int big) {
        int sum = small;
        for(int i = small + 1;i <= big;i++){
            sum += i;
        }
        return sum;
    }
}
