package Learnjava_21_0205;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        int temp = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
        String result = "";
        switch(temp){
            case 0:
               result = "今天周一啦!";
               break;
            case 1:
                result = "今天周二啦!";
                break;
            case 2:
                result = "今天周三啦!";
                break;
            case 3:
                result = "今天周四啦!";
                break;
            case 4:
                result = "今天周五啦!";
                break;
            case 5:
                result = "今天周六啦!";
                break;
            case 6:
                result = "今天周日啦!";
                break;
        }
        System.out.println(result);
    }
}

