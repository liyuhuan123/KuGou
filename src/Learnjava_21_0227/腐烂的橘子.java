package Learnjava_21_0227;

import java.util.LinkedList;
import java.util.Queue;

//链接:https://leetcode-cn.com/problems/rotting-oranges/
public class 腐烂的橘子 {
    //方向矩阵
    public int[][] nextP = {{1,0},{-1,0},{0,1},{0,-1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        if(row == 0){
            return 0;
        }
        int col = grid[0].length;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[] {i,j});
                }
            }
        }
        int minTime = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean flag = false;
            while(size != 0){
                int[] curPos = queue.poll();
                for(int i = 0;i < 4;i++){
                    int newX = curPos[0] + nextP[i][0];
                    int newY = curPos[1] + nextP[i][1];
                    if(newX < 0 || newX >= row || newY < 0 || newY >= col){
                        continue;
                    }
                    if(grid[newX][newY] == 1){
                        grid[newX][newY] = 2;
                        queue.offer(new int[] {newX,newY});
                        flag = true;
                    }
                }
                size--;
            }
            if(flag){
                minTime++;
            }
        }
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return minTime;
    }
}
