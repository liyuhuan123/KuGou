package Learnjava_1019;

public class 剑指offer {
    //https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
    //0~n-1中缺失的数字
    //1.极端情况
    // 当数组长度为0时，返回0
    //当数组中第一个元素不等于0时，那么确实的元素肯定是0
    //当数组长度为1时，如果第一个元素为0，那么缺失的肯定是1
    //2.利用二分查找处理一般情况
    //每次比较中间位置mid是否和中间元素nums[mid]匹配，如果下标和对应元素相等
    //当下标等于最后一个位置时，则令low = mid + 1
    //当下标不等于最后一个元素时，则令low = mid + 1，证明mid之前的元素都没有确实，继续监测mid之后的元素
    //如果下标等于0，则缺失元素是0，
    //如果mid-1的位置的元素和对应下标匹配，那么确实的元素是mid
    //否则令high=mid-1，证明确实的元素一定在mid左侧
//https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
    //字符串转数字
    public int missingNumber(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        if(nums[0] > 0){
            return 0;
        }
        if(nums.length == 1){
            if(nums[0] == 0){
                return 1;
            }else{
                return 0;
            }
        }
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = (left + right) / 2;
            if(mid == nums[mid]){
                if(mid == nums.length - 1){
                    return mid + 1;
                }
                left = mid + 1;
            }else if(nums[mid] > mid){
                if(mid - 1 == nums[mid - 1]){
                    return mid;
                }
                if(mid == 0){
                    return 0;
                }
                right = mid - 1;
            }
        }
        if(left != nums[left]){
            return nums[left] - 1;
        }
        return left + 1;
    }
    //把字符串转换成整数
    public int strToInt(String str) {
        if(str.length() == 0 || str == null){
            return 0;
        }
        char[] arr = str.trim().toCharArray();
        if(arr.length == 0){
            return 0;
        }
        int flag = 1;
        int result = 0;
        int i = 0;
        if(arr[0] == '-'){
            flag = -1;
            i = 1;
        }else if(arr[0] == '+'){
            i = 1;
        }
        int count = Integer.MAX_VALUE / 10;
        for(;i < arr.length;i++){
            if(arr[i] < '0' || arr[i] > '9'){
                break;
            }
            if(result > count || result == count && arr[i] > '7') {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (arr[i] - '0');

        }
        return result * flag;
    }
}
