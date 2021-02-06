package Learnjava_21_0206;
//链接:https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class 跳台阶 {
    public int JumpFloor(int target) {
        if(target <= 2){
            return target;
        }
        int f1 = 1;
        int f2 = 2;
        int fn = 0;
        for(int i = 3;i <= target;i++){
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }
}
