package Learnjava_1219;
//链接:https://leetcode-cn.com/problems/rotate-image/
public class 旋转图像 {
    //A[0,0]旋转到A[0,n]位置,A[0,n]旋转到A[n.n]位置
    //A[n,n]旋转到A[n,0]位置,A[n,0]旋转到A[0,0]位置
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for(int i = 0;i < length / 2;i++){
            int start = i;
            int end = length - i - 1;
            for(int j = 0;j < end - start;j++){
                int temp = matrix[start][start + j];
                matrix[start][start + j] = matrix[end - j][start];
                matrix[end - j][start] = matrix[end][end - j];
                matrix[end][end - j] = matrix[start + j][end];
                matrix[start + j][end] = temp;
             }
        }
    }
}
