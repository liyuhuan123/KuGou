package Learnjava_21_0118;
//链接:https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11191&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
import java.util.ArrayList;

public class 和为s的连续正数序列 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 1;i < sum;i++){
            ArrayList<Integer> list = new ArrayList<>();
            int count = 0;
            for(int j = i;j < sum;j++){
                if(count < sum){
                    sum += j;
                    list.add(j);
                    if(count == sum){
                        result.add(list);
                        break;
                }
                }else{
                    break;
                }
            }
        }
        return result;
    }
}
