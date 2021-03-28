package Learnjava_21_0328;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public int[] pondSizes(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < land.length;i++){
            for(int j = 0;j < land[0].length;j++){
                int x = DFS(land,i,j,row,col);
                if(x != 0){
                    list.add(x);
                }
            }
        }
        Collections.sort(list);
        int[] result = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
    public int DFS(int[][] land,int x,int y,int row,int col){
        int count = 0;
        if(x < 0 || x >= row || y < 0 || y >= col || land[x][y] != 0){
            return count;
        }
        count++;
        land[x][y] = -1;
        count += DFS(land, x + 1, y,row,col);
        count += DFS(land, x - 1, y,row,col);
        count += DFS(land, x, y + 1,row,col);
        count += DFS(land, x, y - 1,row,col);
        count += DFS(land, x + 1, y + 1,row,col);
        count += DFS(land, x + 1, y - 1,row,col);
        count += DFS(land, x - 1, y + 1,row,col);
        count += DFS(land, x - 1, y - 1,row,col);
        return count;
    }
}
