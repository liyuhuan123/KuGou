package Learnjava_1027;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
public class 数组中数字出现的次数 {
    //时间复杂度O(n),空间复杂度O(1)
    public int[] singleNumbers(int[] nums) {
        //1.先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
        //在异或结果中找到任意为 1 的位。
        //根据这一位对所有的数字进行分组。
        //在每个组内进行异或操作，得到两个数字
        //2.基于set实现
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            boolean flag = set.add(nums[i]);
            if(!flag){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        int[] res = new int[2];
        int i = 0;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            res[i] = iterator.next();
            i++;
        }
        return res;
    }
}
