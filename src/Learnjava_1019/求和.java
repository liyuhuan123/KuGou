package Learnjava_1019;

public class 求和 {
    //求 1+2+...+n ，
    // 要求不能使用乘除法、for、while、if、else、switch、case等关键字
    // 及条件判断语句（A?B:C）
    public int sumNums(int n) {
        int sum = n;
        boolean result = (n > 0) && ((sum += sum - sumNums(n - 1)) > 0);
        return sum;
    }
}
