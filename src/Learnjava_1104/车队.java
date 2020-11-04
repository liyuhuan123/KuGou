package Learnjava_1104;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//1.算出每辆车单独到达target所需的时间time，因为所有车的初始位置各不相同，所以可以用
//position和time构成HashMap，对position进行升序排序
//2.用双指针从后往前遍历position，如果后一辆车到达target所需时间<=前一辆车
//说明两辆车在同一车队
//链接：https://leetcode-cn.com/problems/car-fleet/
public class 车队 {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length <= 0){
            return 0;
        }
        Map<Integer,Double> map = new HashMap<>();
        for(int i = 0;i < position.length;i++){
            double temp = (double)(target - position[i]) / speed[i];
            map.put(position[i],temp);
        }
        Arrays.sort(position);
        int result = 0;
        int pre = position.length - 2;
        int cur = position.length - 1;
        while(pre >= 0){
            if(map.get(position[pre]) <= map.get(position[cur])) {
                pre--;
            }else{
                result++;
                cur = pre;
                pre--;
            }
        }
        return result + 1;
    }
}
