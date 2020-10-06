package LearnJava_0422;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyComp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1,Integer o2){
        //sort默认升序排序
        //compare方法相当于什么叫小
        //如果想降序排序，把o1,o2谁的数值大，定义为“小”
        return o2-o1;
    }
}
public class TestLambda {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(7);
        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(8);
        //sort默认是升序排序
        Collections.sort(arrayList,(Integer o1,Integer o2) ->{
            return o2 - o1;
        });
        System.out.println(arrayList);
    }
}
