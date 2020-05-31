package Learnjava_0531;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializableTest implements java.io.Serializable {
    private String name;
    private List<Food> foods = new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableTest t = new SerializableTest();
        t.name = "快餐店";
        t.foods.add(new Food("牛排"));
        t.foods.add(new Food("咖啡"));
        t.foods.add(new Food("小龙虾"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(t);//序列化java对象为二进制数据
        t.name = "慢慢吃";
        t.foods.get(1).name = "牛奶";
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SerializableTest t2 = (SerializableTest) ois.readObject();
        System.out.println(t);
        System.out.println(t2);


    }

    @Override
    public String toString() {
        return "SerializableTest{" +
                "name='" + name + '\'' +
                ", foods=" + foods +
                '}';
    }

    private static class Food implements Serializable{
        private String name;

        public Food(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
