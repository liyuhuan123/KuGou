package Learnjava_0827;

import java.util.Scanner;

public class excise {
    //在一个二维数组中，每一行都按照从左到右递增的顺序排序，
    // 每一列都按照从上到下递增的顺序排序。请完成一个函数，
    // 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    // 时间复杂度小于O(n) ,空间复杂度O(1)
    public static boolean Find(int target, int[][] array){
        for(int i = 0;i < array.length;i++){
            int row = 0;
            int col = array[i].length - 1;
            while(row <= col){
                int z = (row + col) / 2;
                if (target > array[i][z]) {
                    row = z + 1;
                }else if(target < array[i][z]){
                    col = z - 1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][]array = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        System.out.println(Find(3,array));
    }
}
