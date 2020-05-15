package Learnjava_0515;

public class FirstBlood {
    public static void main(String[] args) throws InterruptedException {
        //1.观察main线程阻塞
//      Thread.sleep(9999999999L);
        //2.观察子线程阻塞
//        new Thread(new Runnable(){
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(9999999999L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"第一滴水").start();
        //3.观察子线程和主线程都阻塞
//        new Thread(new Runnable(){
        //系统调度线程，线程处于运行态的时候，执行的代码
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(9999999999L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"第一滴水").start();//.start启动一个线程，申请系统调度并运行
//        Thread.sleep(9999999999L);
        //4.main线程调用run方法
        //子线程没有启动
//        Thread t = new Thread(new Runnable(){
//            @Override
//            //系统调度线程，线程处于运行态的时候，执行的代码
//            public void run() {
//                try {
//                    Thread.sleep(9999999999L);//代码行在哪个线程中就让哪个线程休眠给定的时间
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"第一滴水");
//        t.run();//在main线程对象的方法调用，没有启动子线程，相当于实例方法的调用
//
        //5.main和主线程同时运行并打印，观察执行顺序
         new Thread(new Runnable(){
             @Override
             public void run() {
                     System.out.println("第一滴水");
             }
         },"第一滴水").start();
        System.out.println("main");
        //输出如下
        //main
        //第一滴水
        }
    }
