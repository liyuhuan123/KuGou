package Learnjava_21_0228;

import java.util.*;

//链接:https://leetcode-cn.com/problems/word-ladder/
public class 单词接龙 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        //标记已经搜索过的单词
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Set<String> dict = new HashSet<>();
        for(String wd : wordList){
            dict.add(wd);
        }
        int step = 1;
        while(!queue.isEmpty()){
            //获取上一次转换之后单词的个数
            int num = queue.size();
            while(num-- != 0){
                String curWord = queue.poll();
                if(curWord.equals(endWord)){
                    return step;
                }
                //修改一个位置的字符
                for(int i = 0;i < curWord.length();i++){
                    StringBuilder sb = new StringBuilder(curWord);
                    for(char ch = 'a' ;ch <= 'z';ch++){
                        sb.setCharAt(i,ch);
                        String changeWord = sb.toString();
                        //判断修改之后的单词是否在词典中,且没有搜索过
                        if(dict.contains(changeWord) && !visited.contains(changeWord)){
                            queue.offer(changeWord);
                            visited.add(changeWord);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
