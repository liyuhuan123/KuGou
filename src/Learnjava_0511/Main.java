package Learnjava_0511;

import java.util.Scanner;

public class Main {
    //迷路的牛牛
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dir = new String[]{"N","E","S","W"};
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            String str = scanner.next();
            int count = 0;
            for(int i = 0;i < n;i++){
                if(str.charAt(i) == 'L'){
                    count--;
                }else{
                    count++;
                }
            }
            count %= 4;
            if(count < 0){
                count += 4;
            }
            System.out.println(dir[count]);
        }
    }

}
