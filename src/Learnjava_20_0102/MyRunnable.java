package Learnjava_20_0102;
//方法二:实现Runnable接口
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
