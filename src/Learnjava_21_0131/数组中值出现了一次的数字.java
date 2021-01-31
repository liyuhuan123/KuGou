package Learnjava_21_0131;

import java.util.*;

public class 数组中值出现了一次的数字 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
        }
    }
        public void FindNumsAppearOnce(int [] array) {
            if(array==null)
                return;
            int first=0, second=0, sum=0;
            for(int i=0; i<array.length; i++){
                sum = sum ^ array[i];
            }
            int a = 0;
            int b = 0;
            int right1 = sum & (~sum + 1);
            for(int i=0; i<array.length; i++)
                if((array[i]&right1)!=0)
                    first = first ^ array[i];
            a = first;
            b = sum ^ first;
            if(a > b){
                int temp = a;
                a = b;
                b = a;
        }
    }

}
