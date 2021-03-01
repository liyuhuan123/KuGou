package Learnjava_21_0301;

import java.util.HashSet;
import java.util.Set;

//链接:https://leetcode-cn.com/problems/letter-tile-possibilities/
public class 活字印刷 {
    public void DFS(String tiles, int[] visited, String curStr, Set<String> allRet){
        if(!curStr.isEmpty()){
            allRet.add(curStr);
        }
        for(int i = 0;i < tiles.length();i++){
            if(visited[i] == 0){
                visited[i] = 1;
                DFS(tiles,visited,curStr + tiles.charAt(i),allRet);
                //回溯
                visited[i] = 0;
            }
        }
    }
    public int numTilePossibilities(String tiles) {
        Set<String> allRet = new HashSet<>();
        int[] visited = new int[tiles.length()];
        DFS(tiles,visited,"",allRet);
        return allRet.size();
    }
}
