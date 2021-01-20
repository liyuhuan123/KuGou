package learnjava_21_0120;

import java.util.Scanner;

public class 统计每个月兔子的总数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int month = sc.nextInt();
            System.out.println(helper(month));
        }
    }
    private static int helper(int month){
        if(month == 1 || month == 2){
            return 1;
        }else{
            return helper(month - 1) + helper(month - 2);
        }
    }
}
