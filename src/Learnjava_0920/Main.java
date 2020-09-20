package Learnjava_0920;

public class Main {
    //解码字母到整数映射
    // https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
    public String freqAlphabets(String s) {
        int len = s.length();
        StringBuilder ans = new StringBuilder();
        for (int index = len - 1; index >= 0; index--) {
            if (s.charAt(index) == '#'){
                int val = 10 * (s.charAt(index - 2) - '0' ) + (s.charAt(index - 1) - '0' ) - 1;
                ans.append('a' + val );
                index -= 2;
            }else {
                ans.append('a' + s.charAt(index) - '1');
            }
        }
        return reverse(ans.toString());
    }

    private String reverse(String ans) {
        char[] res = ans.toCharArray();
        int left = 0;
        int right = ans.length() - 1;
        while(left < right){
            char temp = res[left];
            res[left] = res[right];
            res[right] = temp;
        }
        return String.valueOf(res);
    }

}
