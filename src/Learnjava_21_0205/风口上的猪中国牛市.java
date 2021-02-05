package Learnjava_21_0205;

import java.util.ArrayList;
import java.util.List;

public class 风口上的猪中国牛市 {
    public static int calculateMax(int[] prices) {
        int result = 0;
        List<Integer> list = new ArrayList<>();
        int maxGap = 0;
        int temp = 0;
        for(int i = 1;i < prices.length;i++){
            int gap = prices[i] - prices[i - 1];
            list.add(gap);
            if(gap >= 0){
                temp += gap;
            }else{
                if(temp > maxGap){
                    result = maxGap > result ? maxGap : result;
                    maxGap = temp;
                }else{
                    result = temp > result ? temp : result;
                }
                temp = 0;
            }
        }
        result = result + maxGap + temp - Math.min(result,Math.min(maxGap,temp));
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,8,5,1,7,8};
        System.out.println(calculateMax(arr));

    }
}
