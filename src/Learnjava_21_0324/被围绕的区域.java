package Learnjava_21_0324;

public class 被围绕的区域 {
    public void solve(char[][] board) {
        int row = board.length;
        if(row <= 0){
            return;
        }
        int col = board[0].length;
        for(int i = 0;i < col;i++){
            if(board[0][i] == 'O'){
                DFS(board,row,col,0,i);
            }
            if(board[row - 1][i] == 'O'){
                DFS(board,row,col,row - 1,i);
            }
        }
        for(int i = 1;i < row - 1;i++){
            if(board[i][0] == 'O'){
                DFS(board,row,col,i,0);
            }
            if(board[i][col - 1] == 'O'){
                DFS(board,row,col,i,col - 1);
            }
        }
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'a'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public int[][] nextP = {{1,0},{-1,0},{0,1},{0,-1}};
    public void DFS(char[][] board,int row,int col,int x,int y){
        board[x][y] = 'a';
        for(int i = 0;i < 4;i++){
            int nextX = x + nextP[i][0];
            int nextY = y + nextP[i][1];
            if(nextX < 0 || nextX >= row || nextY < 0 || nextY >= col){
                continue;
            }
            if(board[nextX][nextY] == 'O'){
                DFS(board,row,col,nextX,nextY);
            }
        }
    }
}
