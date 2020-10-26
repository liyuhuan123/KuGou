package Learnjava_1026;

public class 在排序数组中查找数字I {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1 && target == nums[0]){
            return 1;
        }
        if(nums.length == 1 && target != nums[0]){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        int count = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            if(target == nums[mid]){
                index = mid;
                count++;
                break;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        for(int i = index - 1;i >= 0 && nums[i] == target;i--){
            count++;
        }
        for(int i = index + 1;i < nums.length && nums[i] == target;i++){
            count++;
        }
        return count;
    }
}
