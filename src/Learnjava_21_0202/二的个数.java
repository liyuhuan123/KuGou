package Learnjava_21_0202;

public class 二的个数 {
    public int countNumberOf2s(int n) {
            int count = 0;
            for(int i = 0;i <= n;i++)//记录从0到n中数字含有2的个数。
                count += fun(i);
            return count;
    }
    public int fun(int n) {
        int a = 0;
        for(;n > 0;n /= 10)//判断一个数中含有2的个数。
            if(n % 10 == 2)
                a++;
        return a;
    }

    public static void main(String[] args) {
        二的个数 s = new 二的个数();
        System.out.println(s.countNumberOf2s(100));
    }
}
