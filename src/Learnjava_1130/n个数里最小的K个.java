package Learnjava_1130;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class n个数里最小的K个 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            helper(arr);
        }
    }

    private static void helper(String[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < arr.length - 1;i++){
            list.add(Integer.valueOf(arr[i]));
        }
        Collections.sort(list);
        int k = Integer.valueOf(arr[arr.length - 1]);
        for(int i = 0;i < k;i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
