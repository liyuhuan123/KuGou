package Learnjava_0906;

import java.util.Scanner;
public class Test{
    //统计回文--网易
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String temp = sc.nextLine();
            int count = 0;
            for(int i = 0;i < str.length();i++){
                String s = str.substring(0,i) + temp + str.substring(i,str.length());
                if(helper(s)){
                    count++;
                }

            }
            System.out.println(count);
        }
    }
    private static boolean helper(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
