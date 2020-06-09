package Learnjava_0609;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //n个数里最小的K个数
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            List<Integer> list = new ArrayList<>();
            int k = Integer.parseInt(arr[arr.length - 1]);
            for(int i = 0;i < arr.length - 1;i++){
                list.add(Integer.valueOf(arr[i]));
            }
            Collections.sort(list);
            int i = 0;
            if(k > list.size()){
                System.out.println(list);
            }
            while(i < k){
                System.out.print(list.get(i) + " ");
                i++;
            }
            System.out.println();
        }
    }
}
