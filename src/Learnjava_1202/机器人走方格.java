package Learnjava_1202;

public class 机器人走方格 {
    public int countWays(int x, int y) {
        helper(x,y);
        return helper1(x,y);
    }
    private int helper(int x,int y){
        if(x == 1 || y == 1){
            return 1;
        }
        return helper(x - 1,y) + helper(x,y - 1);
    }
    private int helper1(int x,int y){
        int walk[][] = new int[x + 1][y + 1];
        for(int i = 0;i <= x;i++){
            walk[i][1] = 1;
        }
        for(int i = 0;i <= y;i++){
            walk[1][i] = 1;
        }
        for(int i = 2;i <= x;i++){
            for(int j = 2;j <= y;j++){
                walk[i][j] = walk[i - 1][j] + walk[i][j - 1];
            }
        }
        return walk[x][y];
    }
}
