package Learnjava_21_0108;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"run()方法执行中...");
    }
}
