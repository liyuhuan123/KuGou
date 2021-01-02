package Learnjava_20_0102;
//多线程案例---单例模式
public class Singleton {
//    //1.饿汉模式
//    private static Singleton instance = new Singleton();
//    private Singleton(){}
//    public static Singleton getInstance(){
//        return instance;
//    }
//    //2.懒汉模式---单线程版
//    private static Singleton instance = null;
//    private Singleton(){}
//    public static Singleton getInstance(){
//        if(instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }
    //懒汉模式-多线程版,性能低
//    private static Singleton instance = null;
//    private Singleton(){}
//    public synchronized static Singleton getInstance(){
//        if(instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }
    //懒汉模式-多线程版-二次判断-性能高
    private static volatile Singleton instance = null;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                instance = new Singleton();
            }
        }
        return instance;
    }


}
