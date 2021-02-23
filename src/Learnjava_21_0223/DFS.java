package Learnjava_21_0223;

/**
 * 问题描述:假如有编号为1-3的3张扑克牌和编号为1-3的3个盒子,现在需要将3张牌分别放到3个
 * 盒子中去,且每个盒子只能放一张牌,打印出所有可能的方法
 */
public class DFS {
    //第一种方法:暴力搜索,效率差
    //时间复杂度(O(n^3))
    public void ss1(int n){
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= n;j++){
                for(int k = 1;k <= n;k++){
                    if(i != j && i != k && j != k){
                        System.out.print(i + " " + j + " " + k);
                        System.out.println();
                    }
                }
            }
        }
    }
    //第二种方法:深度优先算法DFS

    /**
     * 1.处理边界
     * 2.处理当前的一种可能
     * 3.处理下一步
     */
    public void ss2(int[] box, int[] used, int idx){
        if(idx == box.length){
            for(int i = 1;i < box.length;i++){
                System.out.print(box[i] + " ");
            }
            System.out.println();
            return;
        }
        //处理当前盒子
        for(int i = 1;i < box.length;i++){
            //判断当前牌是否用过
            if(used[i] == 0){
                //当前没有使用的牌放入当前盒子
                box[idx] = i;
                used[i] = 1;
                //处理下一个盒子
                ss2(box,used,idx + 1);
                //回收当前使用的牌
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        //ss1测试代码
//        DFS dfs = new DFS();
//        dfs.ss1(3);
        //ss2测试代码
        int n = 3;
        int[] box = new int[n + 1];
        int[] used = new int[n + 1];
        DFS dfs = new DFS();
        dfs.ss2(box,used,1);
    }
}
