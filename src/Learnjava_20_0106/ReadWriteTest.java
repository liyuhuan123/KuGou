package Learnjava_20_0106;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteTest {
    private static ReadWriteLock LOCK = new ReentrantReadWriteLock();
    private static Lock READLOCK = LOCK.readLock();
    private static Lock writeLock = LOCK.writeLock();
    public static void readFile(){
        try {
            READLOCK.lock();
            //IO读文件
        } finally {
            READLOCK.unlock();
        }
    }
    public static void writeFile(){
        try {
            writeLock.lock();
            //IO写文件
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        //20个线程读文件
        for(int i = 0;i < 20;i++){
            //
        }
        //20个线程写文件
        for(int i = 0;i < 20;i++){
            //
        }
    }

}
