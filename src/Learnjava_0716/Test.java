package Learnjava_0716;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //坐标移动
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] arr = str.split(";");
            int[][] result = new int[1][2];
            for(int i = 0;i < arr.length;i++){
                if(isValid(arr[i])){
                    switch(arr[i].charAt(0)){
                        case 'A':
                            result[0][0] -= Integer.parseInt(arr[i].substring(1));
                            break;
                        case 'D':
                            result[0][0] += Integer.parseInt(arr[i].substring(1));
                            break;
                        case 'W':
                            result[0][1] += Integer.parseInt(arr[i].substring(1));
                            break;
                        case 'S':
                            result[0][1] -= Integer.parseInt(arr[i].substring(1));
                            break;
                    }
                }else{
                    continue;
                }
            }
            System.out.println(result[0][0] + "," + result[0][1]);
        }
    }

    private static boolean isValid(String s) {
        if(s.equals("") || s == null){
            return false;
        }
        if(s.length() > 3){
            return false;
        }
        if(s.toUpperCase().charAt(0) <= 'Z' && s.toUpperCase().charAt(0) >= 'A'){
            for(int i = 1;i < s.length();i++){
                if(s.charAt(i) > '9' || s.charAt(i) < '0'){
                    return false;
                }
            }
        }
        return true;
    }
}
