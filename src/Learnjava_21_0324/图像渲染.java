package Learnjava_21_0324;

public class 图像渲染 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        if(row <= 0){
            return image;
        }
        int col = image[0].length;
        int oldColor = image[sr][sc];
        int[][] visited = new int[row][col];
        DFS(image,row,col,visited,sr,sc,oldColor,newColor);
        return image;
    }
    public int[][] nextP = {{1,0},{-1,0},{0,1},{0,-1}};
    public void DFS(int[][] image,int row,int col,int[][] visited,int x,int y,int oldColor,int newColor){
        //1.染色
        image[x][y] = newColor;
        visited[x][y] = 1;
        //2.搜索
        for(int i = 0;i < 4;i++){
            int nextX = x + nextP[i][0];
            int nextY = y + nextP[i][1];
            if(nextX < 0 || nextX >= row || nextY < 0 || nextY >= col){
                continue;
            }
            if(image[nextX][nextY] == oldColor && visited[nextX][nextY] == 0){
                DFS(image,row,col,visited,nextX,nextY,oldColor,newColor);
            }
        }
    }
}
