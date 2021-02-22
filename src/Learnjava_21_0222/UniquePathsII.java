package Learnjava_21_0222;
/**
 * 题目描述:根据上述题目,如果在图中加入了一些障碍,有多少种不同的路径
 * 分别用0和1代表区域和障碍
 * 例如:下图表示有一个障碍在3*3的图中央
 * {
 *     [0,0,0],
 *     [0,1,0],
 *     [0,0,0]
 * }
 * 分析:
 * 状态:F(i,j):从(0,0)到(i,j)路径个数
 * F(i,j):
 *      if(obstacle[i][j] == 1)
 *          F(i,j) = 0
 *      else
 *          F(i,j) = F(i,j - 1) + F(i - 1,j)
 * 初始状态:
 *      if(obstacle[i][0] == 0) && obstacle[j][0] == 0 j < i
 *          F(i,0) = 1
 *      if(obstacle[0][i] == 0 && obstacle[0][j] == 0 j < i)
 *          F(0,i) = 1
 *
 */

import java.util.List;

public class UniquePathsII {
    public int uniquePathsWithObstacles(List<List<Integer>> obstacleGrid){
        if(obstacleGrid.isEmpty()){
            return 0;
        }
        int row = obstacleGrid.size();
        int col = obstacleGrid.get(0).size();
        int[][] arr = new int[row][col];
        for(int i = 0;i < row;i++){
            if(obstacleGrid.get(i).get(0) == 0){
                arr[i][0] = 1;
            }else{
                break;
            }
        }
        for(int j = 0;j < col;j++){
            if(obstacleGrid.get(0).get(j) == 0){
                arr[0][j] = 1;
            }else{
                break;
            }
        }
        for(int i = 1;i < row;i++){
            for(int j = 1;j < col;j++){
                if(obstacleGrid.get(i).get(j) == 0){
                    arr[i][j] = arr[i][j - 1] + arr[i][j];
                }
            }
        }
        return arr[row - 1][col - 1];
    }
}
