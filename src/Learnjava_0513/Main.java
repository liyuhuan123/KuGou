package Learnjava_0513;

import java.util.Scanner;
//字符串旋转
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            String[] arr = str.split(";");
            if(arr[0].length() != arr[1].length()){
                System.out.println("false");
                return;
            }
            StringBuilder sb = new StringBuilder(arr[0]);
            sb.append(arr[0]);
            if(String.valueOf(sb).contains(arr[1])){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }
}
