package Learnjava_21_0119;

import java.util.HashMap;
import java.util.Map;

public class 微信红包 {
    public int getValue(int[] gifts, int n) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            if(map.containsKey(gifts[i])){
                map.put(gifts[i],map.get(gifts[i]) + 1);
            }else{
                map.put(gifts[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > (n / 2)){
                return entry.getKey();
            }
        }
        return 0;
    }
}
