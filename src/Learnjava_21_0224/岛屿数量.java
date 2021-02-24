package Learnjava_21_0224;
//链接:https://leetcode-cn.com/problems/number-of-islands/
public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(grid[i][j] == '1'){
                    DFS(grid,i,j,row,col);
                    count++;
                }
            }
        }
        return count;
    }
    public int[][] nextP = {{-1,0},{1,0},{0,1},{0,-1}};
    public void DFS(char[][] grid,int i,int j,int row,int col){
        grid[i][j] = '0';
        for(int k = 0;k < 4;k++){
            int newX = i + nextP[k][0];
            int newY = j + nextP[k][1];
            if(newX < 0 || newX >= row || newY < 0 || newY >= col){
                continue;
            }
            if(grid[newX][newY] == '1'){
                DFS(grid,newX,newY,row,col);
            }
        }
    }
    public void DFS2(char[][] grid,int row,int col,boolean[][] visited,int x,int y){
        //1.标记
        visited[x][y] = true;
        for(int i = 0;i < 4;i++){
            int newX = x + nextP[i][0];
            int newY = y + nextP[i][1];
            if(newX < 0 || newX >= row || newY < 0 || newY >= col){
                continue;
            }
            if(!visited[newX][newY] && grid[newX][newY] == '1'){
                DFS2(grid,row,col,visited,newX,newY);
            }
        }
    }
    public int numIslands2(char[][] grid) {
        int step = 0;
        int row = grid.length;
        if(row == 0){
            return 0;
        }
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                //为陆地且没有访问
                if(grid[i][j] == '1' && !visited[i][j]){
                    DFS2(grid,row,col,visited,i,j);
                    step++;
                }
            }
        }
        return step;
    }
}
