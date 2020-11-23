package Learnjava_1123;

public class 数组中的逆序对 {
    public int count(int[] A, int n) {
        // write code here
        if(A == null ||  n == 0){
            return 0;
        }
        int count = 0;
        for(int i = 0;i < n;i++){
            for(int j = i + 1;j < n;j++){
                if(A[i] > A[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,0};
        数组中的逆序对 t = new 数组中的逆序对();
        System.out.println(t.count(A,8));
    }
}
