package Learnjava_0920;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    //独一无二的出现次数
    // https://leetcode-cn.com/problems/unique-number-of-occurrences/
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i]) + 1);
            }else{
                map.put(arr[i],1);
            }
        }
        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            boolean flag = set.add(entry.getValue());
            if(!flag){
                return false;
            }
        }
        return true;
    }
}
