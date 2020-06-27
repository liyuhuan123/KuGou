package Learnjava_0627;

public class Test {
    //缺失的第一个正数
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int result = 0;
        for(int i = 0;i < length;i++){
            if(nums[i] == 1){
                result++;
                break;
            }
        }
        if(result == 0){
            return 1;
        }
        if(length == 1){
            return 2;
        }
        for(int i = 0;i < length;i++){
            if(nums[i] <= 0 || nums[i] > length){
                nums[i] = 1;
            }
        }
        for(int i = 0;i < length;i++){
            int temp = Math.abs(nums[i]);
            if(temp == length){
                nums[0] = -Math.abs(nums[0]);
            }else{
                nums[temp] = -Math.abs(nums[temp]);
            }
        }
        for(int i = 1;i < length;i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
            if(nums[0] > 0){
                return length;
            }
            return length + 1;
    }
}
