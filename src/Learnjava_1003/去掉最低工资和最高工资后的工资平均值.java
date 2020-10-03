package Learnjava_1003;

import java.util.Arrays;

//链接https://leetcode-cn.com/problems/average-salary-excluding-the-minimum-and-maximum-salary
public class 去掉最低工资和最高工资后的工资平均值 {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double sum = 0;
        for(int i = 1;i < salary.length - 1;i++){
            sum += salary[i];
        }
        return sum / (salary.length - 2);
    }
}
