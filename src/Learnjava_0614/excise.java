package Learnjava_0614;

import java.util.Arrays;

public class excise {
    //转变数组后最接近目标值的数组和
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int sum = 0;
        for(int i = 0;i < arr.length;i++){
            int x = (target - sum) / (arr.length - i);
            if(arr[i] >= x){
                double y = (target - sum) * 1.0 / (arr.length - i);
                if(y - x > 0.5){
                    return x + 1;
                }else{
                    return x;
                }
            }
            sum += arr[i];
        }
        return arr[arr.length - 1];
    }
    //整数反转
    public int reverse(int x) {
        if(x < 0){
            return -1 * helper(x * -1);
        }
        if(x % 10 == 0){
            return helper(x / 10);
        }
        return helper(x);
    }

    private int helper(int num) {
        int result = 0;
        while(num > 0){
            int yu = num % 10;
            num = num / 10;
            if(result > (Math.pow(2,31) - 1) / 10){
                return 0;
            }
            if(result < -1 * (Math.pow(2,31)) / 10){
                return 0;
            }
            result = result * 10 + yu;
        }
        return result;
    }
}
