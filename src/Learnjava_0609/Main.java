package Learnjava_0609;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //删数
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n > 1000){
                n = 1000;
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0;i < n;i++){
                queue.add(i);
            }
            while(queue.size() != 1){
                int count = 2;
                while(count-- != 0){
                    int temp = queue.peek();
                    queue.poll();
                    queue.add(temp);
                }
                queue.poll();

            }
            System.out.println(queue.peek());
        }
    }
}
