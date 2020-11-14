package Learnjava_1114;

import java.util.*;

public class 数组的相对排序 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < arr1.length;i++){
            if(map.containsKey(arr1[i])){
                map.put(arr1[i],map.get(arr1[i]) + 1);
            }else{
                map.put(arr1[i],1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < arr2.length;i++){
            if(map.containsKey(arr2[i])){
                for(int j = 0;j < map.get(arr2[i]);j++){
                    list.add(arr2[i]);
                }
                map.remove(arr2[i]);
            }
        }
        List<Integer> temp = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            for(int i = 0;i < entry.getValue();i++){
                temp.add(entry.getKey());
            }
        }
        Collections.sort(temp);
        list.addAll(temp);
        int[] result = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
