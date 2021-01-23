package Learnjava_21_0123;

import java.util.*;
public class 小易的升级之路{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int boss = sc.nextInt();
            int child = sc.nextInt();
            int[] energy = new int[boss];
            for(int i = 0;i < boss;i++){
                energy[i] = sc.nextInt();
            }
            helper(child,energy,boss);
        }
    }
    private static void helper(int child,int[] energy,int boss){
        for(int i = 0;i < boss;i++){
            if(energy[i] <= child){
                child += energy[i];
            }else{
                int temp = helper2(child,energy[i]);
                child += temp;
            }
        }
        System.out.println(child);
    }
    private static int helper2(int child,int energy){
        int temp = energy % child;
        while(temp != 0){
            energy = child;
            child = temp;
            temp = energy % child;
        }
        return child;
    }
}
