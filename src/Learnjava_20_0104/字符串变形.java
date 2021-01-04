package Learnjava_20_0104;
//链接:https://www.nowcoder.com/practice/c3120c1c1bc44ad986259c0cf0f0b80e?tpId=188&tqId=37042&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking
public class 字符串变形 {
    public String trans(String s, int n) {
        // write code here
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < n;i++){
            if(' ' == s.charAt(i)){
                res.insert(0,sb);
                res.insert(0," ");
                sb = new StringBuilder();
            }
            if('a' <= s.charAt(i) && s.charAt(i) <= 'z'){
                sb.append((char)(s.charAt(i) - 'a' + 'A'));
            }
            if('A' <= s.charAt(i) && s.charAt(i) <= 'Z'){
                sb.append((char)(s.charAt(i) - 'A' + 'a'));
            }
        }
        return res.insert(0,sb).toString();

    }
}
