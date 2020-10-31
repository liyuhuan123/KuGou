package Learnjava_1031;

public class 数字序列中某一位的数字 {
//https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
    public int findNthDigit(int n) {
        if(n < 0){
            return -1;
        }
        if(n <= 9){
            return n;
        }
        int curIndex = 10;
        int boundNum = 10;
        int digit = 2;
        while(n > curIndex + lengthSum(digit)){
            curIndex += lengthSum(digit);
            boundNum += lengthSum(digit);
            digit++;
        }
        int addNum = (n - curIndex) / digit;
        int tempIndex = (n - curIndex) % digit;
        boundNum = boundNum + addNum;
        int result = boundNum;
        for(int i = 1;i < digit - tempIndex;i++){
            result /= 10;
        }
        result %= 10;
        return result;
    }
    private int lengthSum(int digit){
        if(digit == 1){
            return 10;
        }
        int temp = 9;
        for(int i = 1;i < digit;i++){
            temp = temp * 10;
        }
        return digit * temp;
    }
}
