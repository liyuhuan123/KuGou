package Learnjava_0625;

import java.util.List;

public class excise {
    //单词拆分
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] temp = new boolean[n + 1];
        temp[0] = true;
        for(int i = 1;i <= n;i++){
            for(int j = 0;j < i;j++){
                if(temp[j] && wordDict.contains(s.substring(j,i))){
                    temp[i] = true;
                    break;
                }
            }
        }
        return temp[n];
    }

}
