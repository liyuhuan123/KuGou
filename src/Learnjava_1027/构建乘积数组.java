package Learnjava_1027;
//https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
public class 构建乘积数组 {
    public int[] constructArr(int[] a) {
        if(a == null){
            return null;
        }
        if(a.length == 0){
            return new int [0];
        }
        int length = a.length;
        int[] b = new int[length];
        b[0] = 1;
        for(int i = 1;i < length;i++){
            b[i] = b[i - 1] * a[i - 1];
        }
        int temp = 1;
        for(int i = length - 2;i >= 0;i--){
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}
