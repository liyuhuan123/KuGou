package Learnjava_0517;

public class StopThreadTest {
    private static boolean IS_STOP;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                while(!IS_STOP){
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(200);
        //特殊情况出现，需要中断线程
        IS_STOP = true;
    }
}
