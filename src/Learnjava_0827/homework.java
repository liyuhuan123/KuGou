package Learnjava_0827;

import java.util.Arrays;

public class homework {
    //调整数组中元素的位置，使得奇数位于偶数之前.【不限语言】
    public static void change(int[] array){
        int index = 0;
        int cur;
        while(index < array.length){
            if(array[index] % 2 == 0){
                cur = ++index;
                while(array[cur] % 2 == 0){
                    ++cur;
                }
                int temp = array[cur];
                array[cur] = array[index];
                array[index] = temp;
                index++;
            }else{
                index++;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        change(array);
    }
}
