package Learnjava_0917;

public class Main {
    //有多少个小于当前数字的数字
    // https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            int count = 0;
            for(int j = 0;j < nums.length;j++){
                if(nums[i] > nums[j]){
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
