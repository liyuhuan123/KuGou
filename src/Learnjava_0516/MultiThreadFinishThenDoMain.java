package Learnjava_0516;

public class MultiThreadFinishThenDoMain {
    public static void main(String[] args) throws InterruptedException {
        //目前的代码，main先打印，0~19随机打印
        //期望结果，先打印0~19，随机同时打印，全部打印之后，再打印main
//        for(int i = 0;i < 20;i++){
//            final int j =i;
//            new Thread(()->{
//                System.out.println(j);
//            }).start();
//        }
//        System.out.println("main");
        //期望的代码
        Thread[] threads = new Thread[20];
        for(int i = 0;i < 20;i++){
            final int j =i;
            Thread t = new Thread(()->{
                System.out.println(j);
            });
            t.start();
            threads[i] = t;
        }
        for(int i = 0;i < 20;i++){
            threads[i].join();
        }
        System.out.println("main");

    }
}
