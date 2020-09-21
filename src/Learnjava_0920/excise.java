package Learnjava_0920;

import java.util.HashSet;
import java.util.Set;

public class excise {
    //判定字符是否唯一
    // https://leetcode-cn.com/problems/is-unique-lcci/
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < astr.length();i++){
            boolean flag = set.add(astr.charAt(i));
            if(!flag){
                return false;
            }
        }
        return true;
    }
    //商品折扣后的最终价格
    // https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop/submissions/
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for(int i = 0;i < prices.length - 1;i++){
            int j = i + 1;
            while(j < prices.length){
                if(prices[i] >= prices[j]){
                    res[i] = prices[i] - prices[j];
                    break;
                }else{
                    j++;
                    if(j >= prices.length){
                        res[i] = prices[i];
                    }
                }
            }
        }
        res[prices.length - 1] = prices[prices.length - 1];
        return res;
    }
}
