package Learnjava_0525;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] str = sc.nextLine().split(" ");
            if(str.length < 2){
                System.out.println(0);
            }
            int[] nums = new int[str.length];
            for(int i = 0;i < nums.length;i++){
                nums[i] = Integer.parseInt(str[i]);
            }
            int[] num1 = new int[nums.length - 1];
            for(int i = 0;i < num1.length;i++){
                num1[i] = nums[i + 1] - nums[i];
            }
            int max = 0;
            int sum = 0;
            for(int i = 0;i < num1.length;i++){
                sum = sum + num1[i];
                if(sum < 0){
                    sum = 0;
                }
                max = Math.max(sum,max);
            }
            System.out.println(max);
        }
    }
}
