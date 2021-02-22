package Learnjava_21_0222;

import java.util.List;

/**
 * 有n个物品和一个大小为m的背包,给定数组A表示每个物品的大小和数组V表示每个物品的价值
 * 问最多能装入背包的总价值是多大?
 * 分析:
 * 问题:从n个商品中做选择,当包的大小为m时的最大价值
 * 状态F(i,j):从i个商品中做选择,当包的大小为j时的最大价值
 *      A[i - 1] <= j:
 *          F(i,j) = Math.max{F(i - 1,j) , F(i - 1,j - A[i - 1] + V[i - 1]}
 *      A[i - 1] > j:
 *          F(i,j) = F(i - 1,j)
 * 新增的第i个商品.如果选择放入第i个商品:
 *      1.不需要取出已有的商品
 *      2.需要取出已有的部分商品:
 *          a.第i个商品的价值小于取出的商品价值总和(不可放入!!!)
 *          b.第i个商品的价值大于取出的商品价值总和
 */
public class 背包问题 {
    //方法1:利用二维数组
    public int backPack(int m, int[] A, int[] V) {
        if (A == null  || V == null || m < 1 || A.length == 0 || V.length == 0) {
            return 0;
        }
        int N = A.length + 1;
        int M = m + 1;
        int[][] result = new int[N][M];
        for (int i = 1; i < N; ++i) {
            for (int j = 1; j != M; ++j) {
                //第i个商品在A中对应的索引为i-1: i从1开始
                //如果第i个商品大于j,说明放不下， 所以(i,j)的最大价值和(i-1,j)相同
                if (A[i - 1] > j) {
                    result[i][j] = result[i - 1][j];
                } else {
                    //如果可以装下，分两种情况，装或者不装
                    //如果不装，则即为(i-1, j)
                    //如果装，需要腾出放第i个物品大小的空间： j - A[i-1],装入之后的最大价值即为(i - 1,
                    //j - A[i-1]) + 第i个商品的价值V[i - 1]最后在装与不装中选出最大的价值
                    int newValue = result[i - 1][j - A[i - 1]] + V[i - 1];
                    result[i][j] = Math.max(newValue, result[i - 1][j]);
                }

            }
        }
        return result[A.length][m];
    }
    //方法2:对空间的优化:利用一维数组
    public int backPackII(int m, List<Integer> A, List<Integer> V) {
        int[] dp = new int[m + 1];
        for(int i = 0;i < A.size();i++){
            for(int j = m;j >= A.get(i);j--){
                dp[j] = Math.max(dp[j],dp[j - A.get(i)]+V.get(i));
            }
        }
        int res = 0;
        for(int i = 0;i < m+1;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
