package Learnjava_0926;
//设计双端循环队列
// https://leetcode-cn.com/problems/design-circular-deque/submissions/
public class MyCircularDeque {
    private int[] array;
    private int count = 0;
    private int tail = 0;
    private int head = 0;
    public MyCircularDeque(int k) {
        array = new int[k];
    }
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(count >= array.length){
            return false;
        }
        if(head == 0){
            head = array.length - 1;
        }else{
            head--;
        }
        array[head] = value;
        count++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(count >= array.length){
            return false;
        }
        array[tail] = value;
        tail++;
        count++;
        tail = tail % array.length;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(count == 0){
            return false;
        }
        head++;
        head = head % array.length;
        count--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(count == 0){
            return false;
        }
        if(tail ==0){
            tail = array.length - 1;
        }else{
            tail--;
        }
        count--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(count == 0){
            return -1;
        }
        return array[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(count == 0){
            return -1;
        }
        if(tail == 0){
            return array[array.length - 1];
        }
        return array[tail - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count == array.length;
    }
}
