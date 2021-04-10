package Learnjava_21_0410;
//链接:https://leetcode-cn.com/problems/prison-cells-after-n-days/
public class N天后的牢房 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        N = (N - 1) % 14 + 1;
        for (int i = 0; i < N; i++) {
            cells = helper(cells);
        }
        return cells;
    }
    public int[] helper(int[] cells) {
        int[] arr = new int[cells.length];
        arr[0] = 0;
        arr[cells.length - 1] = 0;
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        return arr;
    }
}
