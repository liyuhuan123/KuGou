package Learnjava_0611;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    //个位数统计
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map;
        while(sc.hasNext()){
            String n = sc.nextLine();
            map = new HashMap();
            int[] arr = new int[n.length()];
            for(int i = 0;i < n.length();i++){
                arr[i] = Integer.parseInt(String.valueOf(n.charAt(i)));
            }
            Arrays.sort(arr);
            for(int i = 0;i < arr.length;i++){
                map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
            }
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
}
