package Learnjava_21_0305;

public class Singleton {
    //1.采用volatile修饰instance变量
    public static volatile Singleton instance = null;
    //2.构造方法私有化
    private Singleton(){};

    public static Singleton getInstance() {
        //3.第一次校验:判断对象是否已经实例过,没有实例过才进入加锁代码,否则直接返回
        if(instance == null){
            //4.类对象加锁
            synchronized (Singleton.class){
                //再次判断
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
