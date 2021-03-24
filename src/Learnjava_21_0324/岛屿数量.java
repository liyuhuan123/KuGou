package Learnjava_21_0324;

public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row <= 0){
            return 0;
        }
        int count = 0;
        int col = grid[0].length;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(grid[i][j] == '1'){
                    DFS(grid,row,col,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public int[][] nextP = {{1,0},{-1,0},{0,1},{0,-1}};
    public void DFS(char[][] grid,int row,int col,int x,int y){
        grid[x][y] = '0';
        for(int i = 0;i < 4;i++){
            int nextX = x + nextP[i][0];
            int nextY = y + nextP[i][1];
            if(nextX < 0 || nextX >= row || nextY < 0 || nextY >= col){
                continue;
            }
            if(grid[nextX][nextY] == '1'){
                DFS(grid,row,col,nextX,nextY);
            }
        }
    }
}
