package Learnjava_21_0321;

public class 最长回文串 {
    //动态规划:状态转移方程:dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1]
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length <= 1){
            return s;
        }
        int maxLength = 1;
        int begin = 0;
        boolean[][] dp = new boolean[length][length];
        for(int i = 0;i < s.length();i++){
            dp[i][i] = true;
        }
        for(int cur = 1;cur < length;cur++){
            for(int pre = 0;pre < cur;pre++){
                if(s.charAt(pre) != s.charAt(cur)){
                    dp[pre][cur] = false;
                }else{
                    if(cur - pre < 3){
                        dp[pre][cur] = true;
                    }else{
                        dp[pre][cur] = dp[pre + 1][cur - 1];
                    }
                }
                if(dp[pre][cur] && cur - pre + 1 > maxLength){
                    begin = pre;
                    maxLength = cur - pre + 1;
                }
            }
        }
        return s.substring(begin,maxLength + begin);
    }
}
