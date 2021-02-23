package Learnjava_21_0223;
//链接:https://leetcode-cn.com/problems/flood-fill/
public class 图像渲染 {
    /**每个点:
     * 1.染色
     * 2.上下左右搜索新的点
     * 3.判断新的点是否符合要求
     * 4.处理每一个新的点
     */

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        int[][] visited = new int[row][col];
        int oldC = image[sr][sc];
        DFS(image,row,col,visited,sr,sc,oldC,newColor);
        return image;
    }

    /**
     * @param image 图像
     * @param row 行
     * @param col 列
     * @param visited 标记矩阵
     * @param newX 新的坐标
     * @param newY
     * @param oldC 原来的颜色
     * @param newC 新颜色
     */
    //方向矩阵
    public int[][] nextP ={{-1,0},{1,0},{0,-1},{0,1}};
    public void DFS(int[][] image,int row,int col,int[][] visited,int newX,int newY,int oldC,int newC){
        //1.染色
        image[newX][newY] = newC;
        visited[newX][newY] = 1;
        //2.搜索:上下左右
        for(int i = 0;i < 4;i++){
            int nextX = newX + nextP[i][0];
            int nextY = newY + nextP[i][1];
            //3.判断位置
            //越界
            if(nextX < 0 || nextX >= row || nextY < 0 || nextY >= col){
                continue;
            }
            //颜色如果符合要求,且没有搜索过
            if(image[nextX][nextY] == oldC && visited[nextX][nextY] == 0){
                DFS(image,row,col,visited,nextX,nextY,oldC,newC);
            }
        }
    }
}
