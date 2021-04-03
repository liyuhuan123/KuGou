package Learnjava_21_0403;
//链接:https://www.nowcoder.com/practice/28eb3175488f4434a4a6207f6f484f47?tpId=188&tqId=38339&rp=1&ru=%2Fta%2Fjob-code-high-week&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
public class 最长公共前缀 {
    public String longestCommonPrefix (String[] strs) {
        // write code here
        if(strs.length == 0){
            return "";
        }
        String result = strs[0];
        for(int i = 1;i < strs.length;i++){
            while(!strs[i].startsWith(result)){
                result = result.substring(0,result.length() - 1);
                if(result.length() == 0){
                    return "";
                }
            }
        }
        return result;
    }
}
