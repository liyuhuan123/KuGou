package Learnjava_0605;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            int temp = stack1.pop();
            stack2.push(temp);
        }
        return stack2.pop();
    }
}
