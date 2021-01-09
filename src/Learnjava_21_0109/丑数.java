package Learnjava_21_0109;

public class 丑数 {
    //方法1:暴力法(性能低)
    //从1开始遍历正整数,判断是否为丑数,获取第n个丑数
    public int nthUglyNumber(int n) {
        //参数不合法
        if(n == 1){
            return 1;
        }
        int result = 0;
        int i = 1;
        while(i <= n){
            if(helper(++result)){
                i++;
            }
        }
        return result;
    }
    private boolean helper(int num){
        if(num < 1){
            return false;
        }
        if(num == 1){
            return true;
        }
        while(num % 2 == 0){
            num = num / 2;
        }
        while(num % 3 == 0){
            num = num / 3;
        }
        while(num % 5 == 0){
            num = num / 5;
        }
        return num == 1;
    }
    //方法2:一个丑数可以表示成2^m*3^n*5^k(m,n,k为自然数Z)
    //丑数从小到大的顺序是m,n,k这三个数中的其中一个数+1
    //具体过程如下:
    //1.数组res初始化,存储了第一个元素res[0] = 1;
    //2.比较m,n,k分别加一后的大小,将res[m]*2,res[n]*3,res[k]*5,取最小的那个数
    //如果取得的是res[m]*2,那么m++,其他同理
    public int nthUglyNumber2(int n) {
        if(n < 7){
            return n;
        }
        int[] res = new int[n];
        res[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        int i;
        for(i = 1;i < n;i++){
            res[i] = min(res[t2] * 2,min(res[t3] * 3,res[t5] * 5));
            if(res[i] == res[t2] * 2){
                t2++;
            }
            if(res[i] == res[t3] * 3){
                t3++;
            }
            if(res[i] == res[t5] * 5){
                t5++;
            }
        }
        return res[n - 1];
    }
    private int min(int num1,int num2){
        return num1 < num2 ? num1 : num2;
    }
}
