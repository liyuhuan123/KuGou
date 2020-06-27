package Learnjava_0627;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //小易的升级之路
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int boss = sc.nextInt();
            int child = sc.nextInt();
            int[] bosses = new int[boss];
            for(int i = 0;i < boss;i++){
                bosses[i] = sc.nextInt();
            }
            int boss1 = sc.nextInt();
            int child1 = sc.nextInt();
            int[] bosses1 = new int[boss1];
            for(int i = 0;i < boss1;i++){
                bosses1[i] = sc.nextInt();
            }
            System.out.println(helper(bosses,child,boss));
            System.out.println(helper(bosses1,child1,boss1));
        }
        }

    private static int helper(int[] bosses, int child, int boss) {
        int result = child;
        for(int i = 0;i < boss;i++){
            if(result >= bosses[i]){
                result += bosses[i];

            }else{
                result += GCD(result,bosses[i]);
            }
        }
        return result;
    }

    private static int GCD(int result, int boss) {
        if(result < boss){
            int temp = result;
            result = boss;
            boss = temp;
        }
        int cs = result;
        int bcs = boss;
        int ys = cs % bcs;
        while(ys != 0){
            cs = bcs;
            bcs = ys;
            ys = cs % bcs;
        }
        return bcs;
    }
}
