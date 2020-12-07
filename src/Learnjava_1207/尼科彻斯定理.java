package Learnjava_1207;

import java.util.Scanner;

public class 尼科彻斯定理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            helper(x);
        }
    }
    private static void helper(int x){
        int cur = x * x - x + 1;
        StringBuffer result = new StringBuffer();
        result.append(cur);
        for(int i = 1;i < x;i++){
            result.append("+");
            cur += 2;
            result.append(cur);
        }
        System.out.println(result);
    }
}
