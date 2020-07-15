package Learnjava_0715;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        //句子逆序
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            StringBuffer result = new StringBuffer();
            String[] arr = str.split(" ");
            for(int i = arr.length - 1;i >= 0;i--){
                if(!arr[i].equals(" ")){
                    result.append(arr[i].trim() + " ");
                }
            }
            System.out.println(result.toString().trim());

        }
    }
}
