package Learnjava_21_0222;
//链接:https://leetcode-cn.com/problems/triangle/
import java.util.List;

public class 三角形的最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] array = new int[row][row];
        array[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < row; i++) {
            array[i][0] = array[i - 1][0] + triangle.get(i).get(0);
            for(int j = 1; j < i; j++) {
                array[i][j] = Math.min(array[i - 1][j - 1], array[i - 1][j]) + triangle.get(i).get(j);
            }
            array[i][i] = array[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int res = array[row - 1][0];
        for (int i = 1; i < row; ++i) {
            res = Math.min(res, array[row - 1][i]);
        }
        return res;
    }
}
