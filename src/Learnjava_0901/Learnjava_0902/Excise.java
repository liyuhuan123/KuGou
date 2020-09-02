package Learnjava_0901.Learnjava_0902;

import java.util.Scanner;

public class Excise {
    //买房
//在一条街上有n幢房子，标号从1到n，两个在标号上相差为1的房子视为相邻，
// 这些房子中有k幢房子已有住户。
//现你准备搬入这条街，你能搬入一幢房子的条件是这幢房子没有人住在里面，
// 与此同时由于你非常热爱与邻居进行交流，故而你需要你所入住的房子两边上都有住户。
//现要你求最小的可能符合要求的房子数，以及最大的可能符合要求的房子数。
//Note: 就样例来说，#代表已有住户，-代表空位，这种情况（###---)，
// 没有满足条件的房子，为最小，故输出0
//最大的情况为(#-#-#-)，此种情况有二个位置满足条件，为最大，故输出2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            while(N != 0){
                int n = sc.nextInt();
                int k = sc.nextInt();
                solve(n,k);
                N--;
            }

        }
    }

    private static void solve(int n, int k) {
        if(n <= 2 || k < 2 || n == k){
            System.out.println(0 + " " + 0);
        }else{
            while(k > 0){
                if(k > n / 2){
                    System.out.println(0 + " " + (n - k));
                }else if(2 * k - 1 <= n){
                    System.out.println(0 + " "  + (k - 1));
                }else{
                    k--;
                }
            }
        }
    }
}
