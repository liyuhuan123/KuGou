package LearnJava_0928;

import java.util.HashMap;
import java.util.Map;

//链接:https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
public class 拼写单词 {
    //方法1：用两个HashMap，一个charsMap用来存放所有已知拥有的字母及其个数，StringMap用来存放词汇表中各个单词及其字母个数
    //依次比较两个HashMap中的键值对
    public int countCharacters(String[] words, String chars) {
        Map<Character,Integer> StringMap = new HashMap<>();
        Map<Character,Integer> charsMap = new HashMap<>();
        int length = 0;
        for(int i = 0;i < chars.length();i++){
            if(!charsMap.containsKey(chars.charAt(i))){
                charsMap.put(chars.charAt(i),1);
            }else{
                charsMap.put(chars.charAt(i),charsMap.get(chars.charAt(i)) + 1);
            }
        }
        for(int i = 0;i < words.length;i++){
            String curWord = words[i];
            boolean flag = true;
            for(int j = 0;j < curWord.length();j++){
                if(!StringMap.containsKey(curWord.charAt(j))){
                    StringMap.put(curWord.charAt(j),1);
                }else{
                    StringMap.put(curWord.charAt(j),StringMap.get(curWord.charAt(j)) + 1);
                }
            }
            for(Map.Entry<Character,Integer> e : StringMap.entrySet()){
                if(charsMap.containsKey(e.getKey()) && e.getValue() <= charsMap.get(e.getKey())){
                    flag = true;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                length = length + curWord.length();
            }
            StringMap.clear();
        }
        return length;
    }
    //方法2
    public int countCharacters2(String[] words, String chars) {
        int length = 0;

        int[] charLetters = new int[26];
        //遍历chars，统计出现的字母及其个数
        for(char c : chars.toCharArray()){
            //用字母之间的ASCII值做差的数字来作为下标，int[0] = 1就代表字母a出现了一次
            charLetters[c - 'a'] += 1;
        }
        //遍历words，统计words中每一个单词中出现的字母及其个数
        //Java中循环体的标签真的很好用，可以直接在内层循环中跳到外层循环的下一次操作，就像一个开关，随时开启循环
        a:for(String word : words){
            int[] wordLetters = new int[26];
            for(char w : word.toCharArray()){
                wordLetters[w - 'a'] += 1;
            }
            for(int i = 0;i < 26;i++){
                if(wordLetters[i] > charLetters[i]){
                    continue a;
                }
            }
            length += word.length();
        }
        return length;
    }

}
