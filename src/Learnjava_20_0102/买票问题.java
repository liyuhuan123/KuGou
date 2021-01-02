package Learnjava_20_0102;

public class 买票问题 implements Runnable{
    private int ticket = 1000;//一共1000张票
    @Override
    public void run() {
        for(int i = 0;i < 1000;i++){
            //在同一时刻,只允许一个线程进入代码块处理
            synchronized (this){//表示为程序逻辑上锁
                if(this.ticket > 0){//还有票
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"还有"+this.ticket--+"张票");
                }
            }
        }
    }
}
