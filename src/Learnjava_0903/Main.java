package Learnjava_0903;

import java.util.Scanner;
public class Main{
    //一封奇怪的信
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str = sc.nextLine();
            helper(str1,str);
        }
    }
    private static void helper(String str1,String str){
        int count = 0;
        for(int i = 0;i < str.length();i++){
            char temp = str.charAt(i);
            int index = (temp - 'a') * 2;
            String res = String.valueOf(index);
            count += Integer.parseInt(res);


        }
        if(count < 100){
            System.out.println(1 + " " + count);
        }else if(count % 100 == 0){
            System.out.println((count / 100) + " " + 100);
        }else{
            System.out.println((count / 100 + 1) + " " + count % 100);
        }
    }
}
