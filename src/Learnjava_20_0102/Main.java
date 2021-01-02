package Learnjava_20_0102;
/**
 * 有一个教室,座位有50个,同时有3个老师安排同学的座位
 * 每个老师安排100个同学到这个教室,模拟使用多线程来实现
 * 三个线程同时启动来安排同学
 * 同学可以循环操作来安排,直到座位安排满
 */
public class Main {
    public static void main(String[] args) {
        SynchronizedDemo t = new SynchronizedDemo(10);
        Thread t1 = new Thread(t);
        SynchronizedDemo tt = new SynchronizedDemo(20);
        Thread t2 = new Thread(tt);
        SynchronizedDemo ttt = new SynchronizedDemo(20);
        Thread t3 = new Thread(ttt);
        t1.setName("A");
        t2.setName("B");
        t3.setName("C");
        t1.start();
        t2.start();
        t3.start();
    }
}
