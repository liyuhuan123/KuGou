package Learnjava_0508;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Map_Set {
    public int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int result = 0;
        for(int i = 0;i < nums.length;i++){
            result = result ^ nums[i];
        }
        return result;
    }
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < J.length();i++){
            set.add(J.charAt(i));
        }
        int count = 0;
        for(int i = 0;i < S.length();i++){
            if(set.contains(S.charAt(i))){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.next();
            String result = scanner.next();
            line = line.toUpperCase();
            result = result.toUpperCase();
            Set<Character> set = new HashSet<>();
            for(int i = 0;i < line.length();i++){
                for(int j = 0;j < result.length();j++){
                    if (line.charAt(i) == result.charAt(j)) {
                        continue;
                    }else if(j == result.length() - 1){
                        set.add(result.charAt(j));
                    }
                }
            }
            System.out.println(set);
        }
    }
}
