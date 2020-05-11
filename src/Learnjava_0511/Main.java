package Learnjava_0511;

import java.util.Scanner;

public class Main {
    //牛牛的闹钟
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int N = scanner.nextInt();
            int hour = 0;
            int minitue = 0;
            int[] alarmtime = new int[N];
            for(int i = 0;i < N;i++){
                hour = scanner.nextInt();
                minitue = scanner.nextInt();
                alarmtime[i] = hour * 60 + minitue;
            }
            int spendtime = scanner.nextInt();
            int arriveTime_hi = scanner.nextInt();
            int arriveTime_mi = scanner.nextInt();
            int arriveTime = arriveTime_hi * 60 + arriveTime_mi;
            for(int i = 0;i < N;i++){
                int result = arriveTime - spendtime - alarmtime[i];
                if(result == 0){
                    System.out.println((alarmtime[i] /60) + " " + (alarmtime[i] % 60));
                    break;
                }else if(result > 0){
                    continue;
                }else{
                    System.out.println((alarmtime[i - 1] / 60) + " " + (alarmtime[i - 1] % 60));
                    break;
                }
            }
        }
    }

}
