package Learnjava_0623;

import java.util.Scanner;

public class main{
    //统计每个月兔子的个数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int monthCount = sc.nextInt();
            System.out.println(getTotalCount(monthCount));
        }
    }
    public static int getTotalCount(int monthCount){
        int result = 0;
        if(monthCount >= 4){
            result = getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
        }else if(monthCount == 3){
            result = 2;
        }else{
            result = 1;
        }
        return result;
    }
}
