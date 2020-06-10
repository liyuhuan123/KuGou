package Learnjava_0610;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.Math.abs;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Main {
    public static void main(String[] args) {
        //Fiboncci数列
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
          int n = sc.nextInt();
           System.out.println(step(n));

        }
    }

    private static int step(int n) {
        int num = 0,x = 0;
        while(num >= 0){
            if(Fibonacci(num) >= n){
                x = Fibonacci(num);
                break;
            }else{
                num++;
            }
        }
        int y = Fibonacci(num - 1);
        return Math.min(abs(y - n),abs(x - n));
    }


    private static int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }else{
            if(n == 1){
                return 1;
            }else{
                return Fibonacci(n - 1) + Fibonacci(n - 2);
            }
        }
    }
}
