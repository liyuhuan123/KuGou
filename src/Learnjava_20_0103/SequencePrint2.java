package Learnjava_20_0103;

/**
 * 有三个线程，分别只能打印A，B和C
 * 要求按顺序打印ABC，打印10次
 */
public class SequencePrint2 implements Runnable {
    private String name;
    private Thread prev;
    private Thread self;

    public SequencePrint2(String name, Thread prev, Thread self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
            while(count > 0){
                    synchronized (prev) {
                        synchronized (self) {
                            System.out.print(name);
                            count--;
                            //唤醒在此监视器上等待的单个线程(等待给self加锁的线程)
                            self.notifyAll();
                        }
                            //该线程暂时释放prev的锁,等待再次获得prev的锁,然后执行下面的语句
                            //此时prev还需要被唤醒
                        try {
                            prev.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    }
