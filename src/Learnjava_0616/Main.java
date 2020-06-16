package Learnjava_0616;

import java.util.Scanner;

public class Main {
    //尼科彻斯定理
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            System.out.println(GetSequeOddNum(m));
        }
    }

    public static String GetSequeOddNum(int m) {
        if(m == 1){
            return String.valueOf(1);
        }
        String result = "";
        int start = 0;
        if(m % 2 != 0){
            start = m * m - 2 * (m / 2);
        }else{
            start = m * m - 2 * (m / 2) + 1;
        }
        result += start;
        for(int i = 1;i < m;i++){
            ++start;
            ++start;
            result += "+" + start;
        }
        return result;
    }
}
