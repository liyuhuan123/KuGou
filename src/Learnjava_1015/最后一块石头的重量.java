package Learnjava_1015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 最后一块石头的重量 {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int e : stones) {
            list.add(e);
        }
        while (true) {
            Collections.sort(list);
            if (list.size() < 1) {
                return list.get(0);
            }else if(list.size() == 0){
                return 0;
            }
            if (list.size() >= 2) {
                int temp1 = list.remove(list.size() - 1);
                int temp2 = list.remove(list.size() - 2);
                if (temp1 > temp2) {
                    list.add(temp1 - temp2);
                }
            }
        }
    }
}
