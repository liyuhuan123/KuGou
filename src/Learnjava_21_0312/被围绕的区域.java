package Learnjava_21_0312;

public class 被围绕的区域 {
    //方向矩阵
    public int[][] nextP ={{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(char[][] board) {
        int row = board.length;
        if(row == 0){
            return;
        }
        int col = board[0].length;
        //搜索所有边上的O
        //以每一个边上的O为起点,找到和边上O连通的所有O
        for(int i = 0;i < col;i++){
            //第一行的所有列
            if(board[0][i] == 'O'){
                DFS(board,row,col,0,i);
            }
            //最后一行的所有列
            if(board[row - 1][i] == 'O'){
                DFS(board,row,col,row - 1,i);
            }
        }
        //从第二行到倒数第二行的第一列和最后一列
        //因为第一行和倒数第一行在上面的循环判断过,此处无需判断
        for(int i = 1;i < row - 1;i++){
            //第一列
            if(board[i][0] == 'O'){
                DFS(board,row,col,i,0);
            }
            //最后一列
            if(board[i][col - 1] == 'O'){
                DFS(board,row,col,i,col - 1);
            }
        }
        //替换,恢复
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
    public void DFS(char[][] board,int row,int col,int x,int y){
        //1.标记
        board[x][y] = 'a';
        //2.搜索
        for(int i = 0;i < 4;i++){
            int newX = x + nextP[i][0];
            int newY = y + nextP[i][1];
            //判断

            //越界
            if(newX < 0 || newX >= row || newY < 0 || newY >= col){
                continue;
            }
            //符合条件
            if(board[newX][newY] == 'O'){
                DFS(board,row,col,newX,newY);
            }
        }
    }
}
