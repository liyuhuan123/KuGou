package Learnjava_0526;
//单例，在某些场景下，需要获取同一个对象
//类加载在JVM内部执行，保证了线程间同步互斥的
//1）只执行一次  2）线程安全
public class Sington{
    //1.饿汉式：在类加载的时候，就创建对象，是线程安全的
    public static Sington SINGTON = new Sington();
    private Sington(){}
    public static Sington getInstance(){
        return SINGTON;
    }
    //2.懒汉式：
    public static Sington SINGTON2;
    //省略了构造方法
    //懒汉式的写法存在多线程安全问题：
    //多行代码，并且存在需要分解的代码行--->不具有原子性、可见性
    public static Sington getInstance2(){
        if(SINGTON2 == null){
            SINGTON2 = new Sington();//可以分解成三条指令
        }
        return SINGTON2;
    }
    //3.懒汉式的多线程安全版本
    //存在效率低的问题
    private static Sington Sington3 = null;
    //省略了构造方法
    public synchronized static Sington getInstance3(){
        if(Sington3 == null){
            Sington3 = new Sington();
        }
        return Sington3;
    }
    //4.单例模式的双重校验锁的写法
    private static Sington SINGTON4;
    //省略了构造方法
    public static Sington getInstance4() {
        if (SINGTON4 == null) {

            synchronized (Sington.class) {
                if (SINGTON4 == null) {
                    SINGTON4 = new Sington();
                }
            }
        }
        return SINGTON4;
    }

}

