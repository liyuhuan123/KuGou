package Learnjava_1117;

import java.util.ArrayList;
import java.util.List;
//链接:https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
public class 圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < n;i++){
            list.add(i);
        }
        m = m - 1;
        int index = 0;
        while(list.size() > 1){
            int length = list.size();
            list.remove((m + index) % length);
            index = (m + index) % length;
        }
        return list.get(0);
    }
}
