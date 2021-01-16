package Learnjava_21_0116;

public class 旋转数组 {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || k == 0){
            return;
        }
        int length = nums.length;
        k %= length;
        reverse(nums,0,length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,length - 1);
    }
    private void reverse(int[] nums,int left,int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
