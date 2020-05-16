package Learnjava_0516;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"第一滴水");
        t.start();
        t.join(5000);
    }
}
