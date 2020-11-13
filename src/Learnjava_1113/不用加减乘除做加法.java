package Learnjava_1113;
//链接:https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
public class 不用加减乘除做加法 {
    public int add(int a, int b) {
        while(a != 0){
            int sum = a ^ b;
            int temp = (a & b) << 1;
            a = temp;
            b = sum;
        }
        return b;
    }
}
