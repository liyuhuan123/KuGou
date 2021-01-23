package Learnjava_21_0123;
import java.util.*;
public class 最高分是多少{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] scores = new int[N];
            for(int i = 0;i < N;i++){
                scores[i] = sc.nextInt();
            }
            for(int i = 0;i < M;i++){
                String C = sc.next();
                int A = sc.nextInt();
                int B = sc.nextInt();
                if(C.equals("Q")){
                    //开始下标
                    int start = Math.min(A,B);
                    //结束下标
                    int end = Math.max(A,B);
                    int max = scores[start - 1];
                    for(int j = start;j < end;j++){
                        max = Math.max(max,scores[j]);
                    }
                    System.out.println(max);
                }
                if(C.equals("U")){
                    scores[A - 1] = B;
                }
            }
        }
    }
}
