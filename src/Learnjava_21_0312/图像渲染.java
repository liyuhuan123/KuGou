package Learnjava_21_0312;

public class 图像渲染 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        int[][] visited = new int[row][col];
        int oldC = image[sr][sc];
        DFS(image,row,col,visited,sr,sc,oldC,newColor);
        return image;
    }
    public int[][] nextP = {{-1,0},{1,0},{0,-1},{0,1}};
    public void DFS(int[][] image,int row,int col,int[][] visited,int newX,int newY,int oldC,int newC){
        //染色
        image[newX][newY] = newC;
        visited[newX][newY] = 1;
        //搜索
        for(int i = 0;i < 4;i++){
            int nextX = newX + nextP[i][0];
            int nextY = newY + nextP[i][1];
            //判断位置是否合法
            if(nextX < 0 || nextX >= row || nextY < 0 || nextY >= col){
                continue;
            }
            if(image[nextX][nextY] == oldC && visited[nextX][nextY] == 0){
                DFS(image,row,col,visited,nextX,nextY,oldC,newC);
            }
        }
    }
}
