package Learnjava_1109;
//https://leetcode-cn.com/problems/number-of-islands/
public class 岛屿数量 {
    public int solve (char[][] grid) {
        // write code here
        //首先判断给定的二维数组是不是空的
        //对二维数组遍历以下,对每个元素进行判断
        //如果这个值等于1,那么就把计数器加一,并对该元素四周进行深度搜索
        if(grid.length == 0){
            return 0;
        }
        int count = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    helper(grid,i,j);
                }
            }
        }
        return count;
        }

    private void helper(char[][] grid, int i, int j) {
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 ||  grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        helper(grid,i + 1,j);
        helper(grid,i,j + 1);
        helper(grid,i - 1,j);
        helper(grid,i,j - 1);
}
}
