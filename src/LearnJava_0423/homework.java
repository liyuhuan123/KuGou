package LearnJava_0423;

import java.util.HashMap;
import java.util.Map;

public class homework {
    public int[] numSmallerByFrequency
            (String[] queries, String[] words) {
        int[] arr = new int[queries.length];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < words.length;i++){
            int num = minSize(words[i]);
            map.put(i,num);
        }
        for(int j = 0;j < queries.length;j++){
            int num2 = minSize(queries[j]);
            for(int s : map.keySet()){
                if(map.get(s) > num2){
                    arr[j]++;
                }
            }
        }
        return arr;
    }
    public int minSize(String word){
        char[] array = word.toCharArray();
        char min = array[0];
        for(int i = 1;i < array.length;i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        int count = 0;
        for(char x : array){
            if(x == min){
                count++;
            }
        }
        return count;
    }
    public boolean isValidSudoku(char[][] board) {
        HashMap<String,Boolean> map = new HashMap<>();
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[i] .length;j++){
                char num = board[i][j];
                if(num == '.'){
                    continue;
                }
                String rowKey = i + "row" + num;
                String colKey = j + "col" + num;
                int groupIndex = i / 3 + j / 3 * 3;
                String groupKey = groupIndex + "group" + num;
                if(map.getOrDefault(rowKey,false)
                || map.getOrDefault(colKey,false)
                || map.getOrDefault(groupKey,false)){
                    return false;
                }
                map.put(rowKey,true);
                map.put(colKey,true);
                map.put(groupKey,true);
            }
        }
        return true;
    }
}
