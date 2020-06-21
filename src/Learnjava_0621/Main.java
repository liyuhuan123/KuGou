package Learnjava_0621;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//成绩排序
class Student{
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " " + score;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> list = new ArrayList<>();
        while(sc.hasNext()){
            int n = sc.nextInt();
            String[] name = new String[n];
            int[] score = new int[n];
            for(int i = 0;i < n;i++){
                name[i] = sc.next();
                score[i] = sc.nextInt();
                list.add(new Student(name[i],score[i]));
        }
            for(int i = 0;i < list.size();i++){
                for(int j = 0;j < list.size() - i - 1;j++){
                    if(list.get(j).getScore() > list.get(j + 1).getScore()){
                        Student student = list.get(j);
                        list.set(j,list.get(j + 1));
                        list.set(j + 1,student);
                    }
                }
            }
            for(int i = n - 1;i >= 0;i--){
                System.out.println(list.get(i));
            }

    }
}
}
