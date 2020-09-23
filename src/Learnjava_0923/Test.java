package Learnjava_0923;

import java.util.ArrayList;
import java.util.List;

public class Test {
    //键盘行
    // https://leetcode-cn.com/problems/keyboard-row/
    public String[] findWords(String[] words) {
        String[] rec = new String[3];
        rec[0] = "qwertyuiop";
        rec[1] = "asdfghjkl";
        rec[2] = "zxcvbnm";
        List<String> list = new ArrayList<>();
        for(String str : words){
            for(int j = 0;j < 3;j++){
                boolean flag = true;
                for(int k = 0;k < str.length();k++){
                    char ch = str.charAt(k);
                    if(ch >= 'A' && ch <= 'Z'){
                        ch = (char)(ch + 32);}
                        if(rec[j].indexOf(ch) == -1){
                            flag = false;
                            break;
                        }
                    }
                    if(flag == true){
                        list.add(str);
                        break;
                    }
                }
            }
        return list.toArray(new String[]{});
        }
    }
