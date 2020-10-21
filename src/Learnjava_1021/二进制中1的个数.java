package Learnjava_1021;
//https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
public class 二进制中1的个数 {
    //把一个整数减去1，再与原整数做与运算，会把该整数最右边的1变为0，则一个二进制中有多少个1就可以进行多少次操作
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n &= n - 1;
        }
        return count;
    }
}
