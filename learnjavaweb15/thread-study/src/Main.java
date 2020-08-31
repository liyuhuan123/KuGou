class MyThread extends Thread{
    @Override
    public void run(){
        //代码
        System.out.println(Thread.currentThread().getName());
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
public class Main{
    public static void main(String[] args) {
//        new MyThread().start();
//        new Thread(new MyRunnable()).start();
        //创建线程的方式1
        MyThread myThread = new  MyThread();
        myThread.start();//
        //myThread.run();//run方法直接调用，不会启动一个线程，知识在当前main线程中调用了run这个方法而已
        //创建线程的方式2
        //new Thread(new Runnable()).start();
        }
}
