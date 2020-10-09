package Learnjava_1009;
//链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
public class 所有奇数长度子数组的和 {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for(int i = 1;i <= arr.length;i += 2){
            for(int j = 0;j + i <= arr.length;j++){
                for(int k = j;k < j + i;k++){
                    sum += arr[k];
                }
            }
        }
        return sum;
    }
}
