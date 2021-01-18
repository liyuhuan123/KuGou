package Learnjava_21_0118;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class 成绩排序 {
    static class Student{
        public String name;
        public int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        while(sc.hasNext()){
            int numStu = sc.nextInt();
            int option = sc.nextInt();
            for(int i = 0;i < numStu;i++){
                list.add(new Student(sc.next(),sc.nextInt()));
            }
            if(option == 0){
                list.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.score - o1.score;
                    }
                });
            }else if(option == 1){
                list.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.score - o2.score;
                    }
                });
            }
            for(int i = 0;i < list.size();i++){
                System.out.println(list.get(i).name + " " + list.get(i).score);
            }
        }
    }
}
