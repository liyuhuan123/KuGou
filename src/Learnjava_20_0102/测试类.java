package Learnjava_20_0102;

public class 测试类 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();//线程开始运行
        Thread t1 = new Thread(new MyRunnable());
        t1.start();//线程开始运行
        //方法三:使用匿名内部类创建Thread子类对象
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("使用匿名内部类创建Thread子类对象");
            }
        };
        //方法四:使用匿名类创建Runnable子类对象
        Thread t3 = new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println("使用匿名类创建Runnable子类对象");
            }
        });
        //方法五:使用lambda表达式创建Runnable子类对象
        Thread t4 = new Thread(()-> System.out.println("使用匿名内部类创建Thread子类对象"));
        Thread t5 = new Thread(()->{
            System.out.println("使用匿名类创建Thread子类对象");
        });
    }
}
