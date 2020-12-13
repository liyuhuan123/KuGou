package Learnjava_1213;

public class 测试类 {
    public static void main(String[] args) {
        创建两个线程交替打印1到100 res = new 创建两个线程交替打印1到100();
        Thread thread1 = new Thread(res);
        Thread thread2 = new Thread(res);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }
}
