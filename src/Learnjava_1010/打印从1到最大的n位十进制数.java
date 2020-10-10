package Learnjava_1010;

import java.util.ArrayList;
import java.util.List;

//链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
public class 打印从1到最大的n位十进制数 {
    public int[] printNumbers(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i < Math.pow(10,n);i++){
            list.add(i);
        }
        int[] res = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
