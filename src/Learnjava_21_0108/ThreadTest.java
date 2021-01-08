package Learnjava_21_0108;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        System.out.println(Thread.currentThread().getName()+"main()方法执行结束");
    }
}
