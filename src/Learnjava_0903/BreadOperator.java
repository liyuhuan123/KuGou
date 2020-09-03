package Learnjava_0903;

public class BreadOperator {
    public static volatile int SUM;

    public static void main(String[] args) {
        //启动生产，生产面包
        for(int i = 0;i < 5;i++){
            new Thread(new Producer(),"面包师傅" + i).start();
        }
        //启动消费者线程，消费面包
        for(int i = 0;i < 20;i++){
            new Thread(new Consumer(),"消费者" + i).start();
        }
    }
    //默认生产者：面包师傅生产面包，一次生产三个面包,每个面包师傅生产20次
    //内部类
    private static class Producer implements Runnable{

        @Override
        public void run() {
            try {
                for(int i = 0;i < 20;i++){
                    synchronized(BreadOperator.class) {
                        //生产完以后库存大于100，是不行的，所以库存在97以上就不能再生产了
                        while(SUM + 3 > 100) {
                            //释放对象锁，需要让其他线程进入同步代码块，当前线程需要进入一个阻塞状态
                            BreadOperator.class.wait();
                        }
                        SUM += 3;//生产面包
                        Thread.sleep(1000);
                        BreadOperator.class.notify();
                        System.out.println(Thread.currentThread().getName() + ",生产了，库存为：" + SUM);
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //默认消费者：消费面包，一次消费一个面包，消费者一直消费
    private static class Consumer implements Runnable{

        @Override
        public void run() {
            try {
                while(true){
                    synchronized(BreadOperator.class){
                        //库存为0，不能继续消费，阻塞当前线程，不能继续消费
                        while(SUM == 0){
                            BreadOperator.class.wait();

                        }
                        SUM--;
                        Thread.sleep(1000);
                        //notify()和notifyAll()都是通知调用wait()被阻塞的线程
                        //notify随机唤醒一个wait()阻塞的线程，notifyAll()唤醒全部wait()阻塞的线程
                        //在synchronized代码块结束之后，也就是释放对象锁之后，才会唤醒
                        //等于说，synchronized结束之后，wait()和synchronized代码行阻塞的线程都会被唤醒
                        BreadOperator.class.notify();
                        System.out.println(Thread.currentThread().getName() + ",消费了,库存为:" + SUM);
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

