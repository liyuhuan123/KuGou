package Learnjava_1007;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //使用场景非常少
        //new SerializableTest().new Person2();
//        SerializableTest test = new SerializableTest();
//        test.new Person2();
        Person person = new SerializableTest.Person();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\KuGou\\res/person"));
        oos.writeObject(person);
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("E:\\KuGou\\res/person")
        );
        Person person1 = (Person)ois.readObject();
        System.out.println(person1);
    }
    //序列化
    //静态内部类
    private static class Person implements Serializable {
        private String name;
        private Integer age;

    }
//    private class Person2{
//
//    }
}
