package Learnjava_0916;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    //重新排列字符串
    // https://leetcode-cn.com/problems/shuffle-string/
    public String restoreString(String s, int[] indices) {
        char[] res = new char[s.length()];
        for(int i = 0;i < indices.length;i++){
            res[indices[i]] = s.charAt(i);
        }
        return String.valueOf(res);
    }
    //旅行终点站
    // https://leetcode-cn.com/problems/destination-city/
    //通过Map存储<出发城市,目标城市>对，然后不断地通过出发城市找到目标城市，
    // 再用找到的目标城市作为出发城市进行遍历，直至找不到当前出发城市队形的目标城市

    public String destCity(List<List<String>> paths) {
        Map<String,String> map = new HashMap<>();
        for(List<String> list : paths){
            map.put(list.get(0),list.get(1));
        }
        String city = paths.get(0).get(1);
        while(map.get(city) != null){
            city = map.get(city);
        }
        return city;
    }
    //分割平衡字符串
    // https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
    public int balancedStringSplit(String s) {
        int count = 0;
        int n = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == 'R'){
                n++;
            }
            if(s.charAt(i) == 'L'){
                n--;
            }
            if(n == 0){
                count++;
            }
        }
        return count;
    }
}
