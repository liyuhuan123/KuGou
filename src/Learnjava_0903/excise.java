package Learnjava_0903;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class excise{
    //会话列表-网易
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            for(int i = 0;i < N;i++){
                int k = sc.nextInt();
                int[] arr = new int[k];
                for(int j = 0;j < k;j++){
                    arr[j] = sc.nextInt();
                }
                helper(arr,k);
            }

        }
    }

    private static void helper(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < k;i++){
            if(set.contains(arr[i])){
                set.remove(arr[i]);
            }
            set.add(arr[i]);
        }
        printReverseSet(set);

    }

    private static void printReverseSet(Set<Integer> set) {
        for(int i = set.size() - 1;i >= 0;i--){
            System.out.print(set.toArray()[i]);
            if(i != 0){
                System.out.print(" ");
            }
        }
    }
}
