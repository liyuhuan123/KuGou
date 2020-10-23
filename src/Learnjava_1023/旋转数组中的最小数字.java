package Learnjava_1023;

import java.util.Arrays;

public class 旋转数组中的最小数字 {
    //https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }
}
