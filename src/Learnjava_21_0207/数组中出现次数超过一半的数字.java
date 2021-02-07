package Learnjava_21_0207;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//链接:https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        //第一种方法:Map
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i],map.get(array[i]) + 1);
            }else{
                map.put(array[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > (array.length / 2)){
                return entry.getKey();
            }
        }
        return 0;
    }
    //第二种方法:排序的方法
    public int MoreThanHalfNum_Solution2(int [] array) {
        Arrays.sort(array);
        int target = array[(array.length / 2)];
        int count = 0;
        for(int i = 0;i < array.length;i++){
            if(array[i] == target){
                count++;
            }
        }
        if(count > (array.length / 2)){
            return target;
        }
        return 0;
    }
    
}
