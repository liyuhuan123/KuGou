package Learnjava_0611;

import java.util.Arrays;

public class Test {
    //每日温度
    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for(int i  = 0;i < T.length;i++){
            int j = i + 1;
            while(j < T.length){
                if(T[i] < T[j]){
                    result[i] = j - i;
                    break;
                }
                j++;
                if(j == T.length - 1){
                    result[i] = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] T = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(T)));
    }
}
