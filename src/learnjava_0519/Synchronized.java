package learnjava_0519;

public class Synchronized {
    //1.静态方法上
    public static synchronized void test1(){

    }
    public static void test1_2(){
        synchronized (Synchronized.class){

        }
    }
    //2.实例方法上
    public synchronized void test2(){

    }

    //3.代码块
    public static void main(String[] args) {
        Object o = new Object();
        /**1.对象锁，每个对象有对象头，包含锁
            2.synchronized是获取对象锁的操作
            1）申请对象锁成功，
                （1）持有对象锁进入代码块
                （2）执行代码，
                （3）退出代码块归还对象锁
                    --->JVM会将竞争对象锁失败的线程唤醒
                    --->唤醒的线程重新竞争
                    --->循环1）和2）的逻辑
            2）申请对象锁失败，线程进入一个同步队列中阻塞
                    JVM管理synchronized竞争失败线程，
         、          --->由运行态转变为阻塞态的方式
                    --->将线程放到一个同步队列的数据结构中
                    --->对象锁再次可用，将所有竞争这个对象锁失败的线程唤醒（阻塞态转变为被唤醒）
         **/
        synchronized (o){

        }
    }
}
