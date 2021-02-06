package Learnjava_21_0206;

//链接:https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class 矩形覆盖 {
    public int rectCover(int target) {
        int f0 = 0;
        int f1 = 1;
        int result = 0;
        for(int i = 1;i <= target;i++){
            result = f0 + f1;
            f0 = f1;
            f1 = result;
        }
        return result;
    }
}
