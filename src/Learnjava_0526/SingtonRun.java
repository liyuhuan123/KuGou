package Learnjava_0526;
//1.main线程中同时启动10个线程
//2.多线程下的类加载：SINGTON3= null
//3.调用getInstance3--->线程同步互斥
//4.第一个进入线程，以线程安全的方式，创建好对象，并返回
//当前这个对象已经实例化，其他九个线程全都是以线程同步互斥的方式来获取对象，这个阶段可以并发执行
//现在是按序执行，效率比较低
public class SingtonRun {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Sington.getInstance();
            }).start();
            Sington.getInstance();
        }
    }
}
