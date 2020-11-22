package Learnjava_1122;

import java.util.Scanner;

public class 统计回文 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(helper(str1,str2));
        }
    }
    private static int helper(String str1,String str2){
        int count = 0;
        for(int i = 0;i <= str1.length();i++){
            StringBuilder temp = new StringBuilder(str1);
            temp.insert(i,str2);
            if(flag(temp)){
                count++;
            }
        }
        return count;
    }
    private static boolean flag(StringBuilder temp){
        int left = 0;
        int right = temp.length() - 1;
        while(left < right){
            if(temp.charAt(left) != temp.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
