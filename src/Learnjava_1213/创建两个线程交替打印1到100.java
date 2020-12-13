package Learnjava_1213;
public class 创建两个线程交替打印1到100 implements Runnable{
    public int count = 1;
    public int time = 0;
    @Override
    public void run() {
        while(true){
            synchronized (this){
                notifyAll();
                if(count <= 100){
                    System.out.println(Thread.currentThread().getName()+":"+count);
                    count++;
                    time++;
                    try{
                        wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }else{
                    return;
                }
            }
        }
    }
}
