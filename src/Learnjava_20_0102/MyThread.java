package Learnjava_20_0102;
//方法一:继承Thread类
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("这里是线程运行的代码");
    }
}
