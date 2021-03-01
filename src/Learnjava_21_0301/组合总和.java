package Learnjava_21_0301;

import java.util.ArrayList;
import java.util.List;

//链接:https://leetcode-cn.com/problems/combination-sum/
public class 组合总和 {
    public void DFS(int[] candidates, int target, List<List<Integer>> allRet, List<Integer> curRet, int curSum, int prePos){
        if(curSum >= target){
            //保存累加和为target的解集
            if(curSum == target){
                List<Integer> copy = new ArrayList<>();
                for(int e : curRet){
                    copy.add(e);
                }
                allRet.add(copy);
            }
            return;
        }
        for(int i = prePos;i < candidates.length;i++){
            //当前累加的元素存入解集中
            curRet.add(candidates[i]);
            DFS(candidates,target,allRet,curRet,curSum + candidates[i],i);
            //尝试其他元素.删除当前元素,回溯
            curRet.remove(curRet.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> allRet = new ArrayList<>();
        List<Integer> curRet = new ArrayList<>();
        DFS(candidates,target,allRet,curRet,0,0);
        return allRet;
    }
}
