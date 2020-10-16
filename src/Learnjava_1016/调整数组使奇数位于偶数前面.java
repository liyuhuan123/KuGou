package Learnjava_1016;

public class 调整数组使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if(nums[left] % 2 == 0 && nums[right] % 2 != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }else if(nums[left] % 2 != 0 && nums[right] % 2 == 0){
                left++;
                right--;
            }else if(nums[left] % 2 == 0 && nums[right] % 2 == 0){
                right--;
            }else if(nums[left] != 0 && nums[right] % 2 != 0){
                left++;
            }
        }
        return nums;
    }
}
