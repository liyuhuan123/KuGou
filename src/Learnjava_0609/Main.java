package Learnjava_0609;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //末尾0的个数
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            int count = 0;
//            for(int i = 0;i < n;i++){
//                n /= 5;
//                count += n;
//            }
//            System.out.println(count);
        //数字颠倒
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int result = 0;
            while(n != 0){
                int yu = n % 10;
                result = result * 10 + yu;
                n = n / 10;
            }
            System.out.println(Integer.toString(result));
        }
    }
}
