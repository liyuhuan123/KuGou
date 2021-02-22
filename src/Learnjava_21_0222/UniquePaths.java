package Learnjava_21_0222;

/**
 * 题目描述:一个机器人在m*n大小的地图左上角(起点),机器人每次向下或向右移动,机器人要到达
 * 地图的右下角(终点)
 * 可以有多少种不同的路径从起点走到终点
 * 状态分析:F(i,j):从(0,0)到达(i,j)路径个数
 * 转移方程:F(i,j) = F(i,j-1) + F(i - 1,j)
 * 特殊的:对于第一行和第一列
 * 初始状态:F(i,0) = F(0,j)
 * 返回:
 * F(row - 1,col - 1) = 1
 */

public class UniquePaths {
    public int uniquePaths(int m,int n){
        int[][] pathNum = new int[m][n];
        //F(0,j) = F(i,0) = 1
        for(int i = 0;i < n;i++){
            pathNum[0][i] = 1;
        }
        for(int i = 0;i < m;i++){
            pathNum[i][0] = 1;
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                pathNum[i][j] = pathNum[i][j - 1] + pathNum[i - 1][j];
            }
        }
        return pathNum[m - 1][n - 1];
    }
}
