package Learnjava_20_0102;

public class TestDemo {
    public static void main(String[] args) {
        买票问题 mt = new 买票问题();
        Thread t1 = new Thread(mt,"黄牛A");
        Thread t2 = new Thread(mt,"黄牛B");
        Thread t3 = new Thread(mt,"黄牛C");
        t1.start();
        t2.start();
        t3.start();
    }
}
