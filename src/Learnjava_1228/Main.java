package Learnjava_1228;

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        for(int i = 1;i < 21;i++){
            Thread t = new Thread(myThread);
            t.setName(String.valueOf(i));
            t.start();
        }
    }
}
