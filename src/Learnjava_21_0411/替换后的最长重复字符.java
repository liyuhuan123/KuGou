package Learnjava_21_0411;
//链接:https://leetcode-cn.com/problems/longest-repeating-character-replacement
public class 替换后的最长重复字符 {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];//创建一个数组,用来存储字母出现的次数
        int left = 0;
        int right = 0;//头尾指针
        int maxn = 0;//当前区间字母的最大出现次数
        int n = s.length();
        while(right < n){
            int index = s.charAt(right) - 'A';
            arr[index]++;
            maxn = Math.max(arr[index],maxn);//重现判断当前区间的最大出现次数
            //判断是否满足当前区间的最大字串
            //最大出现次数maxn+k<区间长度,即该区间最大值也就maxn+k,left右移
            if(right - left + 1 - maxn > k){
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        //区间最大长度等于right-left+1
        //最后一个实际right=right-1
        return right - left;
    }
}
