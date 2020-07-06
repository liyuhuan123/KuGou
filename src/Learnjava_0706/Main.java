package Learnjava_0706;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //简单错误记录
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        while(sc.hasNext()){
            String str = sc.nextLine();
            int index = str.lastIndexOf("\\");
            if(index != 1){
                str = str.substring(index + 1);
            }
            if(!map.containsKey(str)){
                map.put(str,map.get(str) + 1);
            }
        }
        Set<String> set = map.keySet();
        int count = 0;
        for(String temp : set){
            count++;
            if(count > (set.size()) - 8){
                String[] s = temp.split(" ");
                String name = s[0];
                int len = name.length();
                if(len > 16){
                    name = name.substring(len - 16);
                }
                int line = Integer.parseInt(s[1]);
                int number = map.get(temp);
                System.out.println(name + " " + line + " " + number);
            }
        }

    }
}
