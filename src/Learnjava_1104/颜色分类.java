package Learnjava_1104;

import java.util.Arrays;

//这里可以使用七大排序中的稳定排序算法对nums数组进行升序排序
//稳定排序算法：冒泡排序，插入排序，归并排序
//不稳定排序算法：快速排序，选择排序，堆排序，希尔排序
//链接：https://leetcode-cn.com/problems/sort-colors/
public class 颜色分类 {
        public void sortColors(int[] nums) {
            if(nums == null || nums.length <= 0){
                return;
            }
            for(int i = 1;i < nums.length;i++){
                int cur = nums[i];
                int j = i - 1;
                for(;j >= 0;j--){
                    if(nums[j] > cur){
                        nums[j + 1] = nums[j];
                    }else{
                        break;
                    }
                }
                nums[j + 1] = cur;
            }
            System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1,0,0,2};
        颜色分类 res = new 颜色分类();
        res.sortColors(arr);
    }
}
