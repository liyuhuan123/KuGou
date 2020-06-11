package Learnjava_0611;

public class Test {
    //构建乘积数组
    public int[] multiply(int[] A) {
        if(A == null || A.length <= 1){
            return A;
        }
        int len = A.length;
        int[] res = new int[len];
        res[0] = 1;
        for(int i = 1;i < len;i++){
            res[i] = res[i - 1] * A[i - 1];
        }
        int temp  = A[len - 1];
        for(int j = len - 2;j >= 0;j--){
            res[j] = res[j] * temp;
            temp *= A[j];
        }
        return res;
    }
}
