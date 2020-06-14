package Learnjava_0614;

public class test {
    //爬楼梯
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        if(n > 0){
            arr[1] = 1;
        }
        if(n > 1){
            arr[2] = 2;
        }
        if(n > 2){
            for(int i = 3;i < arr.length;i++){
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }
        return arr[n];
    }
    //区域和检索-数组不可变
    private int[] numArray;
    public void NumArray(int[] nums) {
        numArray = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for(int k = i;k <= j;k++){
            sum += numArray[k];
        }
        return sum;
    }
    //三步问题
    public int waysToStep(int n) {
        long[] result = new long[n + 2];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        for(int i = 3;i <= n;i++){
            result[i] = (result[i - 1] + result[i - 2] + result[i - 3]) % 1000000007;
        }
        return (int)result[n];
    }
}
