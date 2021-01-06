package Learnjava_20_0106;

import java.util.ArrayList;
import java.util.List;

//链接:https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=188&&tqId=37004&rp=1&ru=/ta/job-code-high-week&qru=/ta/job-code-high-week/question-ranking
public class 调整顺序使奇数位于偶数前面 {
    //思路:
    //如果前一个是偶数,后一个是奇数,则交换
    public void reOrderArray(int [] array) {
        if(array == null || array.length <= 1){
            return ;
        }
        for(int i = 1;i < array.length;i++){
            for(int j = i;j > 0;j--){
                if (isOddNum(array[j]) && !isOddNum(array[j - 1])) {

                    swap(array,j,j - 1);
                }
            }
        }

    }
    private boolean isOddNum(int num){
        if(num % 2 != 0){
            return true;
        }else{
            return false;
        }
    }
    private void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //方法2
    public void reOrderArray2(int [] array) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0;i < array.length;i++){
            if(isOddNum(array[i])){
                list1.add(array[i]);
            }else{
                list2.add(array[i]);
            }
        }
        list1.addAll(list2);
        for(int i = 0;i < array.length;i++){
            array[i] = list1.get(i);
        }
    }
}
