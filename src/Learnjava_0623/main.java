package Learnjava_0623;

import java.util.Scanner;

public class main{
    //最难的问题
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            char[] array = str.toCharArray();
            for(int i = 0;i < array.length;i++){
                char temp = array[i];
                if(temp >= 'A'){
                    temp = (char) (('E' < temp) ? (temp - 5) : temp + 21);
                    array[i] = temp;
                }
            }
            System.out.println(new String(array));
        }
    }
    public static int getTotalCount(int monthCount){
        int result = 0;
        if(monthCount >= 4){
            result = getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
        }else if(monthCount == 3){
            result = 2;
        }else{
            result = 1;
        }
        return result;
    }
}
