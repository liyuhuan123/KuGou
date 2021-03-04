package Learnjava_21_0304;
//链接:https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class 把字符串转换成整数 {
    public int StrToInt(String str) {
        int result = 0;
        if(str.length() == 0 || str == null){
            return result;
        }
        char[] arr = str.toCharArray();
        for(int i = 0;i < arr.length;i++){
            if(i == 0 && (arr[i] == '+' || arr[i] == '-')){
                continue;
            }else if(arr[i] == '0'){
                result *= 10;
            }else if(arr[i] >= '1' && arr[i] <= '9'){
                result = result * 10 + (arr[i] - '0');
            }else{
                return 0;
            }
        }
        if(arr[0] == '+' || (arr[0] >= '1' && arr[0] <= '9')){
            return result;
        }else if(arr[0] == '-'){
            return result * (-1);
        }
        return result;
    }
}
