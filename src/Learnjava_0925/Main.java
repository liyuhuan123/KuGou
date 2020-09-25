package Learnjava_0925;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    //栈的弹出压入序列
    // https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&&tqId=11174&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
    private List<Integer> intArrayToList(int[] array){
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < array.length;i++){
            list.add(array[i]);
        }
        return list;
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        List<Integer> pushList = intArrayToList(pushA);
        List<Integer> popList = intArrayToList(popA);
        //实现准备的栈
        Deque<Integer> stack = new LinkedList<>();
        while(!popList.isEmpty()){
            int p = popList.remove(0);
            while(true){
                if(stack.isEmpty() || stack.peek().intValue() != p){
                    if(pushList.isEmpty()){
                        return false;
                    }
                    int q = pushList.remove(0);
                    stack.push(q);
                }else{
                    break;
                }
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}
