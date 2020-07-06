package Learnjava_0706;

import java.util.Scanner;

public class test {
    //2的个数
    public int countNumberOf2s(int n) {
        // write code here
        int count = 0;
        int low = 0;
        int current = 0;
        int high = 0;
        int flag = 1;
        while(n / flag != 0){
            low = n - (n / flag) * flag;
            current = (n / flag) % 10;
            high = (n / flag) / 10;
            if(current == 1 || current == 0){
                count += high * flag;
            }else if(current == 2){
                count += high * flag + low + 1;
            }else{
                count += (high + 1) * flag;
            }
            flag *= 10;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //在雷格沃茨找零钱
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String[] arr1 = str1.split(".");
            String[] arr2 = str2.split(".");
            int a = 0,b = 0,c = 0;
            int i = 0,j = 0;
            while(i < arr1.length && j < arr2.length){

            }
        }
    }
}
