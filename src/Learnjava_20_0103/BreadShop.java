package Learnjava_20_0103;
/**
 * 面包店
 * 10个生产者,每个每次生产3和
 * 20个消费者,每个每次消费1个
 * 升级版需求:面包师傅每个最多生产30个
 *          消费者不再一直消费,把面包消费完结束
 * 隐藏信息:面包店每天生产面包的最大数量,面包店每天生产10 * 30 * 3个面包
 *         消费者不再一直消费,把900个面包消费完结束
 */
public class BreadShop {
    private static int CONSUMER_NUM = 10;//消费者数量
    private static int CONSUME_COUNT = 5;//每次消费的面包数
    private static int PRODUCER_NUM = 5;//生产者数量
    private static int PRODUCE_TIMES = 10;//生产者的生产次数
    private static int PRODUCE_COUNT = 3;//每次生产的面包树数
    private static int MAX_COUNT = 100;
    //面包店库存
    private static int COUNT;
    //面包店生产面包的总数,不会消费
    private static int PRODUCE_NUM;
    //消费者
    public static class Consumer implements Runnable{

        private String name;
        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                while(true){
                    synchronized (BreadShop.class){
                        if(PRODUCE_NUM == PRODUCER_NUM * PRODUCE_TIMES * PRODUCE_COUNT){
                            break;
                        }
                        //库存到达下限,不能继续消费,需要阻塞等待
                        if(COUNT == 0){
                            BreadShop.class.wait();//释放对象锁
                        }else{
                            //库存>0,允许消费
                            System.out.printf("消费者%s消费了%s个面包\n",name,CONSUME_COUNT);
                            COUNT -= CONSUME_COUNT;
                            //通知BreadShop.class.wait(),代码进入阻塞的线程
                            BreadShop.class.notifyAll();
                            //模拟消费的耗时
                            Thread.sleep(500);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //生产者
    public static class Producer implements Runnable{
        private String name;

        public Producer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                //达到生产次数
                for(int i = 0;i < PRODUCE_TIMES;i++){
                    synchronized (BreadShop.class){
                        //库存到达上限,不能继续生产,需要阻塞等待
                        if(COUNT + PRODUCE_COUNT > MAX_COUNT){
                            BreadShop.class.wait();//释放对象锁
                        }else{
                            //库存满足生产条件,允许生产
                            System.out.printf("生产者%s生产了%s个面包\n",name,PRODUCE_COUNT);
                            COUNT += PRODUCE_COUNT;
                            PRODUCE_NUM += PRODUCE_COUNT;
                            //通知BreadShop.class.wait(),代码进入阻塞的线程
                            BreadShop.class.notifyAll();
                            //模拟消费的耗时
                            Thread.sleep(1000);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        //同时启动20个消费者线程
        //同时启动10个生产者线程
        Thread[] consumers = new Thread[CONSUMER_NUM];
        Thread[] producers = new Thread[PRODUCER_NUM];
        for(int i = 0;i < consumers.length;i++){
            consumers[i] = new Thread(new Consumer(String.valueOf(i)));
        }
        for(int i = 0;i < producers.length;i++){
            producers[i] = new Thread(new Producer(String.valueOf(i)));
        }
        for(Thread t : consumers){
            t.start();
        }
        for(Thread t : producers){
            t.start();
        }
    }
}

