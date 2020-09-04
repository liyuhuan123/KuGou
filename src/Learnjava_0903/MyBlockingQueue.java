package Learnjava_0903;
//实现阻塞式队列：面包买卖改良版
// 1.满足线程安全生产、消费的功能
// 2.生产、消费达到上限、下线时，需要阻塞等待
public class MyBlockingQueue<E> {
    private Object[] items;
    private int takeIndex;//弹出元素的索引
    private int putIndex;//添加元素的索引
    private int size;//有效容量
    //构造方法
    public MyBlockingQueue(int capacity){
        items = new Object[capacity];
    }
    public synchronized void put(E e) throws InterruptedException {
        while(size == items.length){//达到上限，需要等待
            wait();
        }
        putIndex = (putIndex + 1) % items.length;//存放元素的索引++。需要满足循环队列索引>数组长度的情况
        items[putIndex] = e;
        size++;
        notifyAll();
    }
    public synchronized E take() throws InterruptedException {
        while(size == 0){//达到下限，需要等待
            wait();
        }
        takeIndex = (takeIndex + 1) % items.length;
        size--;
        notifyAll();
        return (E) items[takeIndex];
    }
    private static int SUM;//库存
    //静态内部类
    private static class Producer implements Runnable{

        @Override
        public void run() {
            SUM += 3;
            System.out.println("生产，库存为：" + SUM);
        }
    }
    private static class Consumer implements Runnable{

        @Override
        public void run() {
            SUM--;
            System.out.println("消费，库存为：" + SUM);
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        MyBlockingQueue<Runnable> queue = new MyBlockingQueue(100);
//        for(int i = 0;i < 5;i++){
//            new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//                        while (true) {
//
//                            queue.put(new Producer());//保存生产任务
//                            Thread.sleep(1000);
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
//        for(int i = 0;i < 5;i++){
//            new Thread(new Runnable(){
//
//                @Override
//                public void run() {
//                    try {
//                        while (true) {
//                            queue.put(new Consumer());
//                            Thread.sleep(1000);
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
//        //main线程取出生产/消费任务
//        while(true){
//            Runnable r = queue.take();
//            r.run();
//        }
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(100);
        for(int i = 0;i < 5;i++){
            final int k = i;
            new Thread(new Runnable(){

                @Override
                public void run() {
                    try {
                        for(int j = 0;j < 100;j++){
                            queue.put(k * 100 + j);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        while(true){
            int num = queue.take();
            System.out.println(num);
        }
    }

}
