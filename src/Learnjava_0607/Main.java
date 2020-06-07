package Learnjava_0607;


import java.util.Scanner;
//不要2
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int W = sc.nextInt();
            int H = sc.nextInt();
            int[][] arr = new int[W][H];
            int count = 0;
            for(int i = 0;i < W;i++){
                for(int j = 0;j < H;j++){
                    if(isTrue(arr,i,j)){
                        count++;
                        arr[i][j] = 2;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isTrue(int[][] arr, int i, int j) {
    if(j + 2 < arr[i].length && arr[i][j + 2] == 2){
        return false;
    }
    if(j - 2 >= 0 && arr[i][j - 2] == 2){
        return false;
    }
    if(i + 2 < arr.length && arr[i + 2][j] == 2){
        return false;
    }
    if(i - 2 >= 0 && arr[i - 2][j] == 2){
        return false;
    }
    return true;
    }
}
