package Learnjava_0918;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //统计好三元组
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        for(int i = 0;i < arr.length - 2;i++){
            for(int j = i + 1;j < arr.length - 1;j++){
                if(Math.abs(arr[i] - arr[j]) <= a){
                    for(int k = j + 1;k < arr.length;k++){
                        if(Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
    //汉明距离
    // https://leetcode-cn.com/problems/hamming-distance/
    public int hammingDistance(int x, int y) {
        //先异或，然后找1的个数
        int z = x ^ y;
        int count = 0;
        while(z != 0){
            z = z & (z - 1);
            count++;
        }
        return count;
    }
    //6和9组成的最大数字
    // https://leetcode-cn.com/problems/maximum-69-number/
    public int maximum69Number (int num) {
        List<Integer> list = new ArrayList<>();
        while(num > 0){
            int yu = num % 10;
            list.add(yu);
            num /= 10;
        }
        for(int i = list.size() - 1;i >= 0;i--){
            if(list.get(i) == 6){
                list.set(i,9);
                break;
            }
        }
        int res = 0;
        int flag = 1;
        for(int i = 0;i < list.size();i++){
            res += list.get(i) * flag;
            flag *= 10;
        }
        return res;
    }
}
