package Learnjava_21_0308;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 木棒拼图 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[][] inputs = new int[n][2];
            for(int i = 0;i < n;i++){
                inputs[i][0] = sc.nextInt();
                inputs[i][1] = sc.nextInt();
            }
            helper(inputs,n);
        }
    }
    public static void helper(int[][] inputs,int n){
        ArrayList list = new ArrayList<>();
        for(int i = 0;i < n;i++){
            if(inputs[i][0] == 1){
                list.add(inputs[i][1]);
            }else{
                list.remove(new Integer(inputs[i][1]));
            }
            if(flag(list)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    public static boolean flag(ArrayList<Integer> list){
        Collections.sort(list);
        int count = 0;
        for(int i = 0;i < list.size() - 1;i++){
            count += list.get(i);
        }
        if(count > list.get(list.size() - 1)){
            return true;
        }
        return false;
    }
}
