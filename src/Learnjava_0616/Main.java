package Learnjava_0616;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //组个最小数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] arr = new int[10];
            for(int i = 0;i < 10;i++){
                arr[i] = sc.nextInt();
            }
            List<Integer> list = new ArrayList<>();
            if(arr[0] != 0){
                for(int i = 1;i < 10;i++){
                    if(arr[i] != 0){
                        list.add(i);
                        arr[i]--;
                        break;
                    }
                }
            }
            for(int i = 0;i < 10;i++){
                for(int j = 0;j < arr[i];j++){
                    list.add(i);
                }
            }
            for(int i : list){
                System.out.print(i);
            }


        }
    }
}
