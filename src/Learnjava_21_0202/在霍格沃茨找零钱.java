package Learnjava_21_0202;

import java.util.Scanner;

public class 在霍格沃茨找零钱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.next();
            String str2 = sc.next();
            String[] arr1 = str1.split(".");
            String[] arr2 = str2.split(".");
            int count1 = 0;
            int count2 = 0;
            count1 += Integer.parseInt(arr1[2]) +  29 * Integer.parseInt(arr1[1]) + 29 * 17 * Integer.parseInt(arr1[0]);
            count2 += Integer.parseInt(arr2[2]) +  29 * Integer.parseInt(arr2[1]) + 29 * 17 * Integer.parseInt(arr2[0]);
            int sub = count2 - count1;
            if(sub > 0) {
                int a = sub / (29 * 17);
                int b = (sub % (29 * 17)) / 29;
                int c = (sub % (29 * 17)) % 29;
                System.out.println(a + "." + b + "." + c);
            }else if(sub == 0){
                System.out.println(0);
            }else{
                sub = -1 * sub;
                int a = sub / (29 * 17);
                int b = (sub % (29 * 17)) / 29;
                int c = (sub % (29 * 17)) % 29;
                System.out.println("-" + a + "." + b + "." + c);
            }

        }
    }
}
