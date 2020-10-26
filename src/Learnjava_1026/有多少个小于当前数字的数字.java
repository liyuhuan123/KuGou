package Learnjava_1026;
//https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
public class 有多少个小于当前数字的数字 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            int count = 0;
            for(int j = 0;j < nums.length;j++){
                if(nums[i] > nums[j]){
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
