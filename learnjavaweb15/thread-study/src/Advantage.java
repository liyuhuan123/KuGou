public class Advantage {

    private static final int NUM = 5;

    private static void increment(){
        int count = 10_0000_0000;
        for(int i = 0;i < count;i++){
            count--;
        }
    }

    //串行方法
    private static void serial(){
        long start = System.currentTimeMillis();//1970-01-01开始，到当前时间的毫秒数
        for(int i = 0;i < NUM;i++){
            increment();
        }
        long end = System.currentTimeMillis();
        System.out.printf("串行执行时间是：%s毫秒\n",end - start);
    }

    //并行方法(有时候Java语义里边，并发这个词既表达并发也表现并行
    private static void parallel(){
        long start = System.currentTimeMillis();//1970-01-01开始，到当前时间的毫秒数
        for(int i = 0;i < NUM;i++){
            new Thread(new Runnable(){
                @Override
                public void run(){
                    increment();
                }
            }).start();
        }
        while(Thread.activeCount() > 1){//使用调试的方式运行
            Thread.yield();//线程让步
        }
        long end = System.currentTimeMillis();
        System.out.printf("并发执行时间是：%s毫秒\n",end - start);
    }

    public static void main(String[] args) {
        serial();
        parallel();
    }
}
