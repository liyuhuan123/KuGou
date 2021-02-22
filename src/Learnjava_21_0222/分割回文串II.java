package Learnjava_21_0222;
//链接:https://leetcode-cn.com/problems/palindrome-partitioning-ii/

/**
 * 题目描述:给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的最少分割次数
 * 分析:问题:字符串s的最小分割次数
 * 状态F(i):字符串前i个字符的最小分割次数
 */
public class 分割回文串II {
    public int minCut(String s) {
        int[] minC = new int[s.length() + 1];
        //F(i) = i - 1
        for(int i = 1;i <= s.length();i++){
           minC[i] = i - 1;
        }
        for(int i = 2;i <= s.length();i++){
            //判断整体
            if(isPal(s,0,i - 1)){
                minC[i] = 0;
                continue;
            }
            for(int j = 1;j < i;j++){
                //j < i && [j + 1,i]
                if(isPal(s,j,i - 1)){
                    minC[i] = Math.min(minC[i],minC[j] + 1);
                }
            }
        }
        return minC[s.length()];
    }
    public boolean isPal(String s,int start,int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public int minCut2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] cut = new int[s.length()];
        for(int j = 0;j < s.length();j++){
            int min = j;//这里设定一个最大值,比如有两个字符(下标分别为0,1)
            for(int i = 0;i <= j;i++){
                if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    //如果i==0,说明[0,j]都是回文,
                    //cut[i-1]+1表示的是分割[0,j-1]+[j,i]需要分割的次数一个解
                    min = i == 0 ? 0 : Math.min(cut[i - 1] + 1,min);
                }
            }
            cut[j] = min;
        }
        return cut[s.length() - 1];
    }
}
