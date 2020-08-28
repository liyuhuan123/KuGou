package Learnjava_0828;

import java.util.Scanner;

public class Test {
    //输出一个数字，表示把字符串B插入字符串A之后构成一个回文串的方法数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String line = sc.nextLine();
            String str = sc.nextLine();
            int count = 0;
            for(int i = 0;i < line.length();i++){
//                StringBuilder sb = new StringBuilder(line);

                String s=line.substring(0,i) + str + line.substring(i,line.length());

                if(isHuiwen(s)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    private static boolean isHuiwen(String str){

        int left = 0;
        int right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
