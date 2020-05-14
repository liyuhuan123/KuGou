package Learnjava_0514;

import java.util.ArrayList;
import java.util.List;

public class YangHui {
    public List<List<Integer>> generate(int numRows){
        //杨辉三角特点
        //1.第一行固定就是一个1
        //2.第二行也固定就是两个1
        //3.第i行，首尾元素都固定是1
        //4.第i行具有i列
        //5.对于第i行来说，第j列是i-1行j-1列值加上i-1行j列的值
        if(numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        //1.先准备第一行，就只有一个元素
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 1){
            return result;
        }
        //2.再插入第二行，就只有2个元素
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if(numRows == 2){
            return result;
        }
        for(int row = 3;row <= numRows;row++){
            //要想知道第row行的情况，就得先知道row - 1行的内容
            List<Integer> prevLine = result.get(row - 1 - 1);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            //第row行应该有row列
            for(int col = 2;col < row;col++){
                int curNum = prevLine.get(col - 1 - 1) + prevLine.get(col - 1);
                curLine.add(curNum);
            }
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
