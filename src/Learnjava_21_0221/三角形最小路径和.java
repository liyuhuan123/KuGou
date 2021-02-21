package Learnjava_21_0221;
//链接:https://leetcode-cn.com/problems/triangle/
import java.util.List;
public class 三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int col = triangle.size();
        int[][] array = new int[col][col];
        array[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < col; i++) {
            array[i][0] = array[i - 1][0] + triangle.get(i).get(0);
            for(int j = 1; j < i; j++) {
                array[i][j] = Math.min(array[i - 1][j - 1], array[i - 1][j]) + triangle.get(i).get(j);
            }
            array[i][i] = array[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int res = array[col - 1][0];
        for (int i = 1; i < col; ++i) {
            res = Math.min(res, array[col - 1][i]);
        }
        return res;
    }
    public int minimumTotal2(List<List<Integer>> triangle) {
        int col = triangle.size();
        int[] array = new int[col + 1];
        for (int i = col - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                array[j] = Math.min(array[j], array[j + 1]) + triangle.get(i).get(j);
            }
        }
        return array[0];
    }
}
