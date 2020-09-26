package Learnjava_0926;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    //比较含退格的字符串
    // https://leetcode-cn.com/problems/backspace-string-compare/
    public static boolean backspaceCompare(String S, String T) {
        Queue<Character> queue1 = new LinkedList<>();
        Queue<Character> queue2 = new LinkedList<>();
        for(int i = 0;i < S.length();i++){
            char temp = S.charAt(i);
            if((queue1.isEmpty()) && temp == '#'){
                continue;
            }else if((!queue1.isEmpty()) && temp == '#'){
                queue1.poll();
            }else{
                queue1.add(temp);
            }
        }
        for(int i = 0;i < T.length();i++){
            char temp = T.charAt(i);
            if(queue2.isEmpty() && temp == '#'){
                continue;
            }else if((!queue2.isEmpty()) && temp == '#'){
                queue2.poll();
            }else{
                queue2.add(temp);
            }
        }
        if(queue1.size() != queue2.size()){
            return false;
        }
        int count = queue1.size();
        for(int i = 0;i < count;i++){
            char temp1 = queue1.poll();
            char temp2 = queue2.poll();
            if(temp1 != temp2){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "ab#c";
        String T = "ad#c";
        System.out.println(backspaceCompare(S,T));
    }
}
