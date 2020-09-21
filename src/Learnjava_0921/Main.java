package Learnjava_0921;

public class Main {
    //增减字符串匹配
    // https://leetcode-cn.com/problems/di-string-match/
    public int[] diStringMatch(String S) {
        int[] arr = new int[S.length() + 1];
        int i = 0;
        int j = S.length();
        for(int k = 0;k < S.length();k++){
            if(S.charAt(k) == 'I'){
                arr[k] = i;
                i++;
            }else{
                arr[k] = j;
                j--;
            }
        }
        arr[S.length()] = i;
        return arr;
    }
    //反转字符串
    // https://leetcode-cn.com/problems/reverse-string/
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
    //除数博弈
    // https://leetcode-cn.com/problems/divisor-game/submissions/
    public boolean divisorGame(int N) {
        if(N % 2 == 1){
            return false;
        }else{
            return true;
        }
    }

}
