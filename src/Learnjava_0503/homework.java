package Learnjava_0503;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class homework {
    public boolean canConstruct
            (String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : magazine.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }else{
                map.put(ch,map.get(ch) + 1);
            }
        }
        for(char ch : ransomNote.toCharArray()){
            if(!map.containsKey(ch)){
                return false;
            }else if(map.get(ch) == 0){
                return false;
            }else{
                map.put(ch,map.get(ch) - 1);
            }
        }
        return true;
    }
}
