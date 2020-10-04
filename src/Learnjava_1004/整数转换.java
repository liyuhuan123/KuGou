package Learnjava_1004;
//链接：https://leetcode-cn.com/problems/convert-integer-lcci/
public class 整数转换 {
    public int convertInteger(int A, int B) {
        int res = 0;
        if(A >= 0 && B >= 0){
            res = helper(A,B);
        }else if(A < 0 && B < 0){
            res = helper((-1) * A,(-1) * B);
        }else if(A < 0 && B > 0){
            res = helper((-1) * A,B) + 1;
        }else if(A > 0 && B < 0){
            res = helper(A,(-1) * B) + 1;
        }
        return res;
    }
    private static int helper(int A,int B){
        int res = 0;
        int c = A ^ B;
        while(c != 0){
            res += c % 2 == 0 ? 0 : 1;
            c /= 2;
        }
        return res;
    }
}
