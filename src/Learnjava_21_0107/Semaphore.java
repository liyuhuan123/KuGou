package Learnjava_21_0107;

import org.junit.Test;

public class Semaphore {
    //阻塞等待一组线程执行完毕,再执行XX任务
    @Test
    public void t1() throws InterruptedException {
        java.util.concurrent.Semaphore s = new java.util.concurrent.Semaphore(0);
        for(int i = 0;i < 20;i++){
            Thread t = new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                s.release();//释放资源量(无参的话就是1)
            });
            t.start();
        }
        s.acquire(20);//获取资源量,子线程执行完毕后,获取到,子线程执行不完,一直阻塞等待
        System.out.println("执行完毕:"+Thread.currentThread().getName());
    }
    //限制有限资源访问
    //模拟服务端接收客户端http请求:只1000个并发
    //在一个时间点,客户端任务数达到1000.再有客户端请求,将阻塞等待
    @Test
    public void t2() throws InterruptedException {
        java.util.concurrent.Semaphore s = new java.util.concurrent.Semaphore(1000);
        for(;;){
            Thread t = new Thread(()->{
                try {
                    s.acquire();//获取资源量,如果没有,一直阻塞等待
                    //模拟每个线程处理客户端http请求
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    s.release();//释放资源量(无参的话就是1)
                }
            });
            t.start();
        }
    }
}
