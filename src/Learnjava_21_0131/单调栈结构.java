package Learnjava_21_0131;

import java.util.*;
public class 单调栈结构{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int[][] res = new int[arr.length][2];
            res = helper(arr);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public static int[][] helper(int[] arr) {
        ArrayDeque<List<Integer>> stack = new ArrayDeque<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek().get(0)]) {
                List<Integer> list = stack.pop();
                int temp = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer x : list) {
                    res[x][0] = temp;
                    res[x][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[i] == arr[stack.peek().get(0)]) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> list = stack.pop();
            int temp = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer x : list) {
                res[x][0] = temp;
                res[x][1] = -1;
            }
        }
        return res;
    }
}
