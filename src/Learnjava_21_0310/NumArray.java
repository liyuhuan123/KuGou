package Learnjava_21_0310;
//链接:https://leetcode-cn.com/problems/range-sum-query-immutable/
public class NumArray {
    //区域和检索-数组不可变
    private int[] numArray;
    public NumArray(int[] nums) {
        numArray = nums;
    }
    public int sumRange(int i, int j) {
        int sum = 0;
        for(int k = i;k <= j;k++){
            sum += numArray[k];
        }
        return sum;
    }
}
