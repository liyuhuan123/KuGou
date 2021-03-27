package Learnjava_21_0327;
//链接:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int price : prices){
            if(min > price){
                min = price;
            }else if(price - min > max){
                max = price - min;
            }
        }
        return max;
    }
}
