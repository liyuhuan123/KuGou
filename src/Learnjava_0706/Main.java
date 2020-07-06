package Learnjava_0706;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //说反话
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            for(int i = arr.length - 1;i > 0;i--){
                System.out.print(arr[i] + " ");
            }
            System.out.print(arr[0]);
            System.out.println();
        }
    }
}
