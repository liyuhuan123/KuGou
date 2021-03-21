package Learnjava_21_0321;
//链接：https://leetcode-cn.com/problems/set-matrix-zeroes/
public class 矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if(row <= 0){
            return;
        }
        int col = matrix[0].length;
        boolean[] newArr1 = new boolean[row];
        boolean[] newArr2 = new boolean[col];
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(matrix[i][j] == 0){
                    newArr1[i] = true;
                    newArr2[j] = true;
                }
            }
        }
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(newArr1[i] || newArr2[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
