package Learnjava_21_0206;
//链接:https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class 旋转数组的最小数字 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0 || array == null){
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while(left < right){
            if(right - left == 1){
                mid = right;
                break;
            }
            if(array[left] == array[right] && array[left] == array[mid]){
                int result = array[left];
                for(int i = left + 1;i < right;i++){
                    if(result > array[i]){
                        result = array[i];
                    }
                }
                return result;
            }
            mid = (left +right) >> 1;
            if(array[mid] >= array[left]){
                left = mid;
            }else{
                right = mid;
            }
        }
        return array[mid];
    }
}
