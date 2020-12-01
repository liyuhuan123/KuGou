package Learnjava_1201;
import java.util.Scanner;
public class 末尾零的个数{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            System.out.println(helper(x));
        }
    }
    private static int helper(int x){
        int result = 0;
        do{
            x /= 5;
            result += x;
        }while(x > 0);
        return result;
    }
}
