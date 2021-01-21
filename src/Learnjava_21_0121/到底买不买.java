package Learnjava_21_0121;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 到底买不买 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.next();
            String str2 = sc.next();
            Map<Character,Integer> map1 = new HashMap<>();
            for(int i = 0;i < str1.length();i++){
                if(map1.containsKey(str1.charAt(i))){
                    map1.put(str1.charAt(i),map1.get(str1.charAt(i)) + 1);
                }else{
                    map1.put(str1.charAt(i),1);
                }
            }
            int result = 0;
            boolean flag = true;
            for(int i = 0;i < str2.length();i++){
                char temp = str2.charAt(i);
                if(map1.containsKey(temp) && map1.get(temp) != 0){
                    map1.put(temp,map1.get(temp) - 1);
                }else{
                    flag = false;
                    result++;
                }
            }
            if(flag){
                for(Map.Entry<Character,Integer> entry : map1.entrySet()){
                    result += entry.getValue();
                }
                System.out.println("Yes"+" "+result);
            }else{
                System.out.println("No"+" "+result);
            }
        }
    }
}
