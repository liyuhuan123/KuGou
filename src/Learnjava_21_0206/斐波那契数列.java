package Learnjava_21_0206;

import java.util.ArrayList;
import java.util.List;

public class 斐波那契数列 {
    //方法1:递归思想
    //时间复杂度:指数级别O(2^n)
    //空间复杂度:O(1)
    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
    //方法2:dp思想
    //空间换时间:空间复杂度:O(n)
    //时间复杂度O(n)
    public int Fibonacci2(int n) {
        List<Integer> list = new ArrayList<>();
        //初始化
        list.add(0);
        list.add(1);
        for(int i = 2;i <= n;i++){
            list.add(list.get(i - 1) + list.get(i - 2));
        }
        return list.get(n);
    }
    //方法3:dp的改良版本
    //空间复杂度:O(1)
    //时间复杂度:O(n)
    public int Fibonacci3(int n) {
        //f(n - 2)
        int fn2 = 0;
        //f(n - 1)
        int fn1 = 1;
        int fn = 0;
        if(n <= 1){
            return n;
        }
        for(int i = 2;i <= n;i++){
            fn = fn1 + fn2;
            fn2 = fn1;
            fn1 = fn;
        }
        return fn;
    }
}
