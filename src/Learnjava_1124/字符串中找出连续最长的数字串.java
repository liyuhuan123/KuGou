package Learnjava_1124;

import java.util.Scanner;

public class 字符串中找出连续最长的数字串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(helper(str));
            break;
        }
    }
    private static String helper(String str) {
        String[] arr = str.split("[^0-9]+");
        String result = "";
        int temp = 0;
        for(int i = 0;i < arr.length;i++){
            if(temp < arr[i].length()){
                result = arr[i];
                temp = arr[i].length();
            }
        }
        return result;
    }
}
