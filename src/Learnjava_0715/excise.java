package Learnjava_0715;

import java.util.Scanner;

public class excise {
    public static void main(String[] args) {
        //删除公共字符
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            char[] ch = str1.toCharArray();
            for(int i = 0;i < ch.length;i++){
                if(!str2.contains(String.valueOf(ch[i]))){
                    System.out.print(ch[i]);
                }
            }
            System.out.println();
        }
    }
}
