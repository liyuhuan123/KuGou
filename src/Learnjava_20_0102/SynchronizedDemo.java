package Learnjava_20_0102;

public class SynchronizedDemo implements Runnable{
    public static int COUNT = 50;
    public int NUM;

    public SynchronizedDemo(int NUM) {
        this.NUM = NUM;
    }

    @Override
    public void run() {
        for(int i = 0;i < 100;i++){
            synchronized (SynchronizedDemo.class){
                if(COUNT > 0 && NUM > 0){
                    COUNT--;
                    NUM--;
                    System.out.printf("%s:count=%s,num=%s\n",
                            Thread.currentThread().getName(),COUNT,NUM);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
