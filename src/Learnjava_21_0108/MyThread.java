package Learnjava_21_0108;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"run()方法正在执行...");
    }
}
