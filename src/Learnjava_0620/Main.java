package Learnjava_0620;

//百万富翁问题
public class Main {

    public static void main(String[] args) {
        int rich = 0;
        int poor = 0;
        rich = 10 * 30;
        poor = (int)(Math.pow(2,30) - 1);
        System.out.println(rich + " " + poor);
    }
}
