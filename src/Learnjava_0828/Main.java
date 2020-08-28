package Learnjava_0828;

public class Main {
    //求一个十进制数字在内存中二进制1的个数。
    public static void main(String[] args) {
        Main find = new Main();
        int t = find.binary(6);
        System.out.println(t);
    }
    public static int binary(int n){
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                count++;
            }
            n = n / 2;
        }
        return count;
    }

}
