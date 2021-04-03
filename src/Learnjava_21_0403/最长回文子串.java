package Learnjava_21_0403;
//链接:https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af?tpId=188&tqId=38290&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
public class 最长回文子串 {
    public int getLongestPalindrome(String A, int n) {
        //动态规划:
        //定义字符串S从下标i到下标j的字符串为P(i,j),若s从下标i到j为回文串
        //则P(i,j) = true,否则P(i,j) = false;
        //转移方程:P(i,j) = P(i + 1.j - 1) && s[i] == s[j]
        int length = A.length();
        int max = 0;
        boolean[][] dp = new boolean[length][length];
        for(int len = 1;len <= length;len++){
            for(int start = 0;start < length;start++){
                int end = start + len - 1;
                //下标越界,结束循环
                if(end >= length){
                    break;
                }
                dp[start][end] = (len == 1 || len == 2 || dp[start + 1][end - 1]) && A.charAt(start) == A.charAt(end);
                if(dp[start][end] && len > max){
                    max = len;
                }
            }
        }
        return max;
    }
}
