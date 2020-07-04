package Learnjava_0704;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        //水仙花数
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int start = sc.nextInt();
            int end = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i = start;i <= end;i++){
                int ge = i % 100 % 10;
                int shi = i % 100 / 10;
                int bai = i / 100;
                if(i == ge * ge * ge + shi * shi * shi + bai * bai * bai){
                    list.add(i);
                }
            }
            if(list.size() == 0){
                System.out.println("no");
            }else{
                Collections.sort(list);
                for(int i = 0;i < list.size();i++){
                    System.out.print(list.get(i) + " ");
                }
            }

            System.out.println();

        }
    }
}
