package Learnjava_0901.Learnjava_0902;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//有一片1000*1000的草地，小易初始站在(1,1)(最左上角的位置)。
// 小易在每一秒会横向或者纵向移动到相邻的草地上吃草(小易不会走出边界)。
// 大反派超超想去捕捉可爱的小易，他手里有n个陷阱。
// 第i个陷阱被安置在横坐标为xi ，纵坐标为yi 的位置上，
// 小易一旦走入一个陷阱，将会被超超捕捉。你为了去解救小易，
// 需要知道小易最少多少秒可能会走入一个陷阱，从而提前解救小易。
public class Main {
    //解救小易
    //解题思路：求其他点距离（1,1）的最短距离，因为他只能横着或者竖着移动，所以d = x+ y - 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            List<Integer> arr1 = new ArrayList<>();
            List<Integer> arr2 = new ArrayList<>();
            for(int i = 0;i < N ;i++){
                arr.add(sc.nextInt());
            }
            for(int i = 0;i < N;i++){
                arr1.add(sc.nextInt());
            }
            for(int i = 0;i < N;i++){
                arr2.add(arr.get(i) + arr1.get(i) - 2);
            }
            Collections.sort(arr2);
            System.out.println(arr2.get(0));
        }
    }
}
