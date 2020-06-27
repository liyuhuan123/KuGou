package Learnjava_0627;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //最高分是多少
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int N = sc.nextInt();//学生的数目
            int M = sc.nextInt();//操作的数目
            int[] array = new int[N];
            array[0] = 0;
            for(int i = 0;i < N;i++){
                array[i] = sc.nextInt();
            }
            for(int i = 0;i < M;i++){
                String[] line = sc.nextLine().split(" ");
                int a = Integer.parseInt(line[1]) - 1;
                int b = Integer.parseInt(line[2]) - 1;
                switch(line[0]){
                    case "Q":
                        int max = 0;
                        for(int j = Math.min(a,b);j <= Math.max(a,b);j++){
                            max = Math.max(max,array[j]);
                        }
                        System.out.println(max);
                        break;
                    case "U":
                        array[a] = b + 1;
                        break;
                }
            }
        }
    }
}
