package Learnjava_0922;

public class Main {
    //生成每种字符都是奇数个的字符串
    // https://leetcode-cn.com/problems/generate-a-string-with-characters-that-have-odd-counts/
    public String generateTheString(int n) {
        String s = "";
        for(int i = 0;i < n - 1;i++){
            s += 'a';
        }
        if(n % 2 == 0){
            s += 'b';
        }else{
            s += 'a';
        }
        return s;
    }
}
