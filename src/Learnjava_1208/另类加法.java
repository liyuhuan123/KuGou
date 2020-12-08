package Learnjava_1208;

public class 另类加法 {
    public int addAB(int A, int B) {
        // write code here
        int ans = 0;
        do{
            ans = A & B;
            A = A ^ B;
            B = ans << 1;
        }while(B != 0);
        return A;
    }
}
