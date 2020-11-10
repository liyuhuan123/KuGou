package Learnjava_1110;
//链接:https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //二维数组是有序的,从右上角来看,向左数字递减,向下数字递增,因此从右上角开始查找
        //当要查找数字比右上角数字大时,下移,
        //当要查找的数字比右上角数字小时,左移.
        //如果出了边界,则说明二维数组中不存在该整数
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix[0].length - 1;
        int n = 0;
        int temp = matrix[n][m];
        while(target != temp){
            if(m > 0 && n < matrix.length - 1){
                if(target > temp){
                    n++;
                }else if(target < temp){
                    m--;
                }
                temp = matrix[n][m];
            }else{
                return false;
            }
        }
        return true;

    }
}
