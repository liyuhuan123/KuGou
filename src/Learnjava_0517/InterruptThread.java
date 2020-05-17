package Learnjava_0517;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        //第一段代码，在子线程sleep阻塞的时候中断
//        Thread t = new Thread(()->{
//            System.out.println(Thread.currentThread().getName());
//            try {
//                while(!Thread.interrupted()){//判断当前线程是否被中断了---判断中断标志位
//                    System.out.println(Thread.currentThread().getName());
//                    Thread.sleep(100000000);//sleep线程阻塞的时候，也可以中断，是以抛出InterruptedException异常来中断的
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        t.start();
//        Thread.sleep(2000);
//        //特殊情况出现，需要中断线程
//        t.interrupt();
        //第二段代码
        //(1)线程初始时，中断标志位 = false
        //(2)调用线程的interrupted()方法，该线程的中断标志位 = true
        //(3)如果线程处于阻塞态，中断抛出InterruptedException异常，重置标志位
//        Thread t = new Thread(()->{//isTnterrupted = false;
//            System.out.println(Thread.currentThread().getName());
//                while(!Thread.interrupted()){
//                    System.out.println(Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(100000000);//sleep线程阻塞的时候，也可以中断，是以抛出InterruptedException异常来中断的
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        t.start();
//        Thread.sleep(2000);
//        //特殊情况出现，需要中断线程
//        t.interrupt();//t.isInterrupted() = true
        //第三段代码，Thread.interrupted作用
//        Thread t = new Thread(()->{//t.interrupted = true;
//            for(int i = 0;i < 10;i++){
//                //Thread.interrupted();返回当前的中断标志位，并重置标志位
//                //(1)boolean temp = isInterrupted;
//                //(2)isInterrupted = false;
//                //(3)return temp;
//                System.out.println(Thread.interrupted());
//            }
//        });
//        t.start();//t.interrupted = false;
//        //特殊情况出现，要中断子线程
//        t.interrupt();//t.interrupted = true;
        //第四段代码，线程对象isInterrupted()作用，只返回中断标志位，不做任何修改
        Thread t = new Thread(()->{//t.interrupted = true;
            for(int i = 0;i < 10;i++){
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        t.start();//t.interrupted = false;
        //特殊情况出现，要中断子线程
        t.interrupt();//t.interrupted = true;

    }
}
