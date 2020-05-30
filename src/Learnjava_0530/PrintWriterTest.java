package Learnjava_0530;
public class PrintWriterTest {
    public static void main(String[] args) {
        try {
            int i = 1 / 0;
            System.out.println("1 / 0");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
        System.out.println("t1");
    }
}
