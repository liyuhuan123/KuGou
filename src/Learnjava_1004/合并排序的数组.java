package Learnjava_1004;
//链接：https://leetcode-cn.com/problems/sorted-merge-lcci/
public class 合并排序的数组 {
    public void merge(int[] A, int m, int[] B, int n) {
        int lengthA = m - 1;
        int lengthB = n - 1;
        int max = m + n - 1;
        while(lengthA >= 0 &&lengthB >= 0){
            if(A[lengthA] > B[lengthB]){
                A[max] = A[lengthA];
                lengthA--;
                max--;
                continue;
            }else{
                A[max] = B[lengthB];
                lengthB--;
                max--;
            }
        }
        while(lengthB >= 0){
            A[max] = B[lengthB];
            max--;
            lengthB--;
        }
    }
}
