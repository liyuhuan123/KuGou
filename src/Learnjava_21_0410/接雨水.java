package Learnjava_21_0410;
//链接:https://leetcode-cn.com/problems/trapping-rain-water/
public class 接雨水 {
    public int trap(int[] height) {
        int left = 1;
        int right = height.length - 2;
        int left_max = 0;//记录左最高
        int right_max = 0;//记录右最高
        int res = 0;
        while(left <= right){
            if(height[left - 1] < height[right + 1]){
                left_max = Math.max(left_max,height[left - 1]);
                if(left_max > height[left]){
                    res += left_max - height[left];
                }
                left++;
            }else{
                right_max = Math.max(right_max,height[right + 1]);
                if(right_max > height[right]){
                    res += right_max - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
