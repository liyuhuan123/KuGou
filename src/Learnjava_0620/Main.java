package Learnjava_0620;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    //数组中值出现了一次的数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            if (N < 2) {
                return;
            }
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            Set<Integer> set = new HashSet<>();
            for (int i : arr) {
                if (!set.add(i)) {
                    set.remove(i);
                } else {
                    set.add(i);
                }
            }
            System.out.println(set.toArray(new Integer[set.size()])[0] + " " + set.toArray(new Integer[set.size()])[1]);
            System.out.println();
        }
    }
}
