package Learnjava_0708;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        //球的半径和体积
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double z1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double z2 = sc.nextDouble();

            double r = Math.sqrt((x1 -x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
            System.out.printf("%.3f",r);
            System.out.print(" ");
            System.out.printf("%.3f",4 * Math.acos(-1) * r * r * r / 3);
        }
    }
}
