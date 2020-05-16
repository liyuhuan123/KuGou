package Learnjava_0516;

public class MyRunnable implements Runnable{
    //方法2实现Runnable接口
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
//        Thread t = new Thread(new MyRunnable());
//        t.start();//线程开始运行
        new Thread(new MyRunnable()).start();
    }
}
