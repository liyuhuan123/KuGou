package Learnjava_0929;
//链接：https://leetcode-cn.com/problems/find-common-characters/submissions/
import java.util.ArrayList;
import java.util.List;

public class 查找常用字符 {
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int[] result = new int[26];
        for(char c : A[0].toCharArray()){
            result[c - 'a']++;
        }
        for(int i = 1;i < A.length;i++){
            int[] temp = new int[26];
            for(char c : A[i].toCharArray()){
                temp[c - 'a']++;
            }
            for(int j = 0;j < 26;j++){
                if(temp[j] == 0 || result[j] == 0){
                    result[j] = 0;
                }else{
                    result[j] = Math.min(result[j],temp[j]);
                }
            }
        }
        for(int i = 0;i < 26;i++){
            if(result[i] > 0){
                for(int j = 0;j < result[i];j++){
                    list.add((char)('a' + i) + "");
                }
            }
        }
        return list;
    }
}
