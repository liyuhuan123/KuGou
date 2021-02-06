package Learnjava_21_0206;
//链接:https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
import java.util.ArrayList;
import java.util.List;
public class 连续子数组的最大和 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(array[0]);
        int max = list.get(0);
        for(int i = 1;i < array.length;i++){
            list.add(Math.max(list.get(i - 1) + array[i],array[i]));
            max = Math.max(max,list.get(i));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }
}
