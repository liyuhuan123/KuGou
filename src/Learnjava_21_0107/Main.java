package Learnjava_21_0107;
//入口线程执行t方法:入口线程阻塞等待,直到所有子线程执行完毕
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    //第一种方式:yield()
    @Test
    public void t1(){
        for(int i = 0;i < 20;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
        while(Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println("执行完毕:"+Thread.currentThread().getName());
    }
    //第二种方式:join()
    @Test
    public void t2() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for(int i = 0;i < 20;i++){
            Thread t = new Thread(()->{
                System.out.println(Thread.currentThread().getName());
            });
            threads.add(t);
            t.start();
        }
        for(Thread t : threads){
            t.join();
        }
        System.out.println("执行完毕:"+Thread.currentThread().getName());
    }
    //第三种方式:CountDownLatch
    @Test
    public void t3() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(20);//计数器的初始值
        for(int i = 0;i < 20;i++){
            Thread t = new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                cdl.countDown();//计数器的值-1
            });
            t.start();
        }
        cdl.await();//当前线程阻塞等待,直到计数器的值等于0
        System.out.println("执行完毕:"+Thread.currentThread().getName());
    }
}
