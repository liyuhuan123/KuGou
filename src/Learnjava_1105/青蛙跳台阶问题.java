package Learnjava_1105;
//https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
public class 青蛙跳台阶问题 {
    public int numWays(int n) {
        if(n == 0){
            return 1;
        }
        if(n <= 2){
            return n;
        }
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3;i < arr.length;i++){
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }
        return arr[n];
    }

}
