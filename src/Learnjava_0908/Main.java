package Learnjava_0908;

import java.util.ArrayList;
import java.util.List;

public class Main {
//左旋转字符串---剑指OFfer
public String reverseLeftWords(String s, int n) {
    int length = s.length();
    if(length == 0){
        return "";
    }
    n = n % length;
    String s1 = s.substring(n,length);
    String s2 = s.substring(0,n);
    return s1 + s2;
}
//打印从1到最大的n位数---剑指offer
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
    //重新排列数组---力扣
    public int[] shuffle(int[] nums, int n) {
    int[] res = new int[nums.length];
    int left = 0;
    int right = n;
    for(int i = 0;i < n;i++){
        res[2 * i] = nums[left];
        left++;
        res[2 * i + 1] = nums[right];
        right++;
    }
    return res;
    }
    //好数对的数目---力扣
    public int numIdenticalPairs(int[] nums) {
    int count = 0;
    for(int i = 0;i < nums.length - 1;i++){
        for(int j = i + 1;j < nums.length;j++){
            if(nums[i] == nums[j]){
                count++;
            }
        }
    }
    return count;
    }

}
