package Learnjava_21_0207;

public class 斐波那契数列的第n项 {
    //方法1:迭代的方法
    public int Fibonacci(int n){//f(n - 2) + f(n - 1) = f(n)
        if(n == 0){
            return n;
        }
        if(n <= 2){
            return n;
        }
        int first = 1;
        int second = 1;
        int third = 1;
        while(n > 2){
            third = first + second;
            first = second;
            second = third;
            n--;
        }
        return third;
    }
    public int Fibonacci2(int n){//f(n - 2) + f(n - 1) = f(n)
        if(n == 0){
            return n;
        }
        if(n <= 2){
            return n;
        }
        return Fibonacci2(n - 1) + Fibonacci2(n - 2);
    }
}
