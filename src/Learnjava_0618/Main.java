package Learnjava_0618;

public class Main {
    //另类加法
    public int addAB(int A, int B) {
        // write code here
        int sum = 0;
        int carry = 0;
        while(B != 0){
            sum = A ^ B;
            carry = (A & B) << 1;
            A = sum;
            B = carry;
        }
        return sum;
    }
}
