package Learnjava_0516;

public class MyThread extends Thread{
    //方法1继承Thread类
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new MyThread().start();
    }
}
