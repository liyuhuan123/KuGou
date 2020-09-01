package Learnjava_0901;

import java.util.Scanner;

public class Test {
    //数字反转
    //对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。
    // 例如:
    //如果 X = 123，则rev(X) = 321;
    //如果 X = 100，则rev(X) = 1.
    //现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int result = rev(x) + rev(y);
            System.out.println(rev(result));
        }
    }
    private static int rev(int x){
        String str = "";
        while(x != 0){
            int a = x % 10;
            str += a;
            x = x / 10;
        }
        return Integer.parseInt(str);
    }
}
