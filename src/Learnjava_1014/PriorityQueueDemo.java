package Learnjava_1014;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main2(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(5);
        queue.add(2);
        queue.add(7);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        //2 3 5 7
    }

    public static void main(String[] args) {
        PriorityQueue<Person> queue = new PriorityQueue<>(new Comparator<Person>(){
            @Override
            public int compare(Person o1,Person o2){
                return o1.age - o2.age;
            }
        });
        Person p1 = new Person("高博",18);
        Person p2 = new Person("陈培鑫",30);
        Person p3 = new Person("唐中",67);
        Person p4 = new Person("sujfi",89);
        queue.add(p1);
        queue.add(p2);
        queue.add(p3);
        queue.add(p4);
        System.out.println(queue.remove());
    }
}
