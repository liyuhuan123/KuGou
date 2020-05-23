package Learnjava_0523;

import static java.lang.Thread.*;

public class Main {
//    private static int SUM;
//    public static synchronized void increment(int n){
//        SUM++;
//    }
    private Object o = new Object();
    private static Object T = Main.class;
    public static synchronized void t1() throws InterruptedException {
        sleep(999999999);
    }
    public synchronized void t2() throws InterruptedException {
        sleep(999999999);
    }
    public void t3() throws InterruptedException {
        synchronized (o){
            sleep(999999999);
        }
    }
    public void t4() throws InterruptedException {
        synchronized (T){
            sleep(999999999);
        }
    }

    public static void main(String[] args) {
//        for(int i = 0;i < 20;i++){
//            new Thread(()->{
//                for(int j = 0;j < 10000;j++){
//                    increment(j);
//                }
//            }).start();
//        }
        //t2方法在不同线程中执行时，是否有同步互斥
        //情况1:不是同一个对象，不会同步互斥
        new Thread(()->{
            try{
                new Main().t2();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try{
                new Main().t2();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }).start();
        //情况2：是同一个对象，具有同步互斥
        Main t = new Main();
        new Thread(()->{
            try{
                t.t2();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try{
                t.t2();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }
}
