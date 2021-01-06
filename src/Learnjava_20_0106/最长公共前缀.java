package Learnjava_20_0106;
//链接:https://www.nowcoder.com/practice/28eb3175488f4434a4a6207f6f484f47?tpId=188&&tqId=37028&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
public class 最长公共前缀 {
    //思路:
    //让数组的第一个元素成为前缀,然后循环字符串数组,判断数组中的每一个元素是否
    //以声明的那个前缀一样,一样就不动,不一样就将声明的那个前缀从0-长度减一
    //循环直到每一个元素都开头的那个前缀
    public String longestCommonPrefix (String[] strs) {
        // write code here
        if(strs.length == 0){
            return "";
        }
        //判断数组中的每一个元素是否以result开头,不是的话,让result-`,再判断是否与数组中的元素相同
        String result = strs[0];
        for(int i = 1;i < strs.length;i++){
            while(!strs[i].startsWith(result)){
                result = result.substring(0,result.length() - 1);
                if(result.isEmpty()){
                    return "";
                }
            }
        }
        return result;
    }
}
