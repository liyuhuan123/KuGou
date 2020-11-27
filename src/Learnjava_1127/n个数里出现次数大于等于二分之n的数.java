package Learnjava_1127;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class n个数里出现次数大于等于二分之n的数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            int[] nums = new int[arr.length];
            for(int i = 0;i < arr.length;i++){
                nums[i] = Integer.parseInt(arr[i]);
            }
            helper(nums);
        }
    }
    private static void helper(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() >= nums.length / 2){
                System.out.println(entry.getKey());
            }
        }

    }
}
