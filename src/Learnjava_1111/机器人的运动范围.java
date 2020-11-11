package Learnjava_1111;
//链接:https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
public class 机器人的运动范围 {
    private int reachable;
    private boolean[][] visit;
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};
    public int movingCount(int m, int n, int k) {
        reachable = 0;
        visit = new boolean[m][n];
        backtrack(0, 0, m, n, k);
        return reachable;
    }
    public void backtrack(int x, int y, int m, int n, int k) {
        if (x < 0 || x >= m || y < 0 || y >= n
                || visit[x][y] || getBitSum(x, y) > k) {
            return;
        }
        visit[x][y] = true;
        reachable++;
        for (int i = 0; i < 4; i++) {   // 搜索 4 个方向
            backtrack(x + dx[i], y + dy[i], m, n, k);
        }
    }
    public int getBitSum(int x, int y) {
        return x / 10 + x % 10 + y / 10 + y % 10;
    }
}

