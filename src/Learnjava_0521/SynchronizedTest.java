package Learnjava_0521;
//线程安全
public class SynchronizedTest {
    //语法
    //1.静态方法上
    public static synchronized void test1(){

    }
    //2.实例方法上
    public synchronized void test2(){

    }
    //3.代码块
    public static void main(String[] args) {
        Object o = new Object();
        synchronized(o){//对象

        }
    }
}
