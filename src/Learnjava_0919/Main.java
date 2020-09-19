package Learnjava_0919;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    //唯一摩尔斯密码词
    // https://leetcode-cn.com/problems/unique-morse-code-words/
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new TreeSet<>();
        for(String word : words){
            StringBuilder res = new StringBuilder();
            for(int i = 0;i < word.length();i++){
                res.append(codes[word.charAt(i) - 'a']);
            }
            set.add(res.toString());
        }
        return set.size();
    }
    //机器人能否返回原点
    // https://leetcode-cn.com/problems/robot-return-to-origin/
    public boolean judgeCircle(String moves) {
        int ord = 0;//纵坐标
        int abs = 0;//横坐标
        for(int i = 0;i < moves.length();i++){
            char temp = moves.charAt(i);
            switch(temp){
                case 'R' : abs += 1;
                break;
                case 'L' : abs -= 1;
                break;
                case 'U' : ord += 1;
                break;
                case 'D' : ord -= 1;
                break;
                default : break;

            }
        }
        if(abs == 0 && ord == 0){
            return true;
        }
        return false;
    }
    //自除数
    // https://leetcode-cn.com/problems/self-dividing-numbers/
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left;i <= right;i++){
            int init = i;
            int d;
            boolean flag = true;
            while(init != 0){
                d = init % 10;
                if(d == 0 || i % d != 0){
                    flag = false;
                    break;
                }else{
                    init = init / 10;
                }
            }
            if(flag){
                list.add(i);
            }
        }
        return list;
    }
}
