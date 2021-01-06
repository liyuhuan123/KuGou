package Learnjava_20_0106;
//链接:https://www.nowcoder.com/practice/fc897457408f4bbe9d3f87588f497729?tpId=188&&tqId=37010&rp=1&ru=/ta/job-code-high-week&qru=/ta/job-code-high-week/question-ranking
import java.util.Arrays;
import java.util.Comparator;

public class 最大数 {
    public String solve (int[] nums) {
        String[] strArr = new String[nums.length];
        for(int i = 0;i < nums.length;i++){
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuffer result = new StringBuffer();
        if(strArr[0].equals("0")){
            return "0";
        }
        for(String temp : strArr){
            result.append(temp);
        }
        return result.toString();
    }
}
