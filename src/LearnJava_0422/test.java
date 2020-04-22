package LearnJava_0422;

import java.sql.SQLOutput;
import java.util.Scanner;

class Animal{
    public void eat(String food){

    }
}
class Cat extends Animal{
    private String name;
    public Cat(){
        this.name = "小猫";
    }
    public Cat(String name){
        this.name = name;
    }
    @Override
    public void eat(String food){
        System.out.println(this.name + "正在吃" + food);
    }
}
class Bird extends Animal{
    private String name;
    public Bird(){
        name = "小鸟";
    }
    @Override
    public void eat(String food){
        System.out.println(this.name + "正在吃" + food);
    }
}
public class test {
    public static void main(String[] args)
            throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        //1.如何获取类对象
        //1)通过字符串来获取到类，参数是类的全限定类名[最重要]
        //catClass就是cat类的图纸，里头描述了Cat类的内部构造
        //通过字符串获取就意味着，这个字符串可以是用户通过控制台输入的，
        //也可以是通过读取文件获取的，还可以是通过网络获取的
//        Class catClass = Class.forName("LearnJava_0422.Cat");
        //2)通过实例来获取,实例的getClass方法获取到类对象
//        Cat cat = new Cat("小黑");
//        Class catClass2 = cat.getClass();
        //得到的类对
        // System.out.println(catClass == catClass2);
        // 3）通过类来获取象在内存中只有一份，不管通过哪种方式获取到的类对象，
        // 本质上都是同一个对象

//        Class catClass3 = Cat.class;
//        System.out.println(catClass == catClass3);
        //2.通过类对象来创建实例
        //平时创建实例都是通过 new 的方式
        //catClass表示Cat类的类对象，也就是Cat类的图纸
        //newInstance创建对应的实例
        //以下代码运行时出现了异常，Cat没有提供无参数的构造方法
        //直接实例化就会出现异常
        Scanner scanner = new Scanner(System.in);
        String className = scanner.next();
        System.out.println("您要创建的实例类型为：" + className);
        Class catClass = Class.forName(className);
        Animal animal = (Animal) catClass.newInstance();
        animal.eat("鱼");
    }
}
