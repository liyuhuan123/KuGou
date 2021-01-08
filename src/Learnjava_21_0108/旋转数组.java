package Learnjava_21_0108;
//链接:https://leetcode-cn.com/problems/rotate-array/
public class 旋转数组 {
    //方法1:每次将数组每一位向后挪动以为,挪动k%nums.length次
    public void rotate(int[] nums, int k) {
        if(nums.length == 0){
            return;
        }
        int right = nums[nums.length - 1];
        for(int i = 0;i < k % nums.length;i++){
            for(int j = nums.length - 1;j > 0;j--){
                nums[j] = nums[j - 1];
            }
            nums[0] = right;
            right = nums[nums.length - 1];
        }
    }
    //方法2:
    //(1)将整个数组反转(后移K位其实是将原数组后K位移到了最前面,但是前后顺序不变,
    //    直接翻转后,已经将后K位移动到最前面了,只是顺序相反
    //(2)将前K位翻转
    //(3)将后n-k位翻转
    public void rotate2(int[] nums, int k) {
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
