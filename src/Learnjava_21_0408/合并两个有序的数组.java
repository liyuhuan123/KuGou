package Learnjava_21_0408;
//连接:https://www.nowcoder.com/practice/89865d4375634fc484f3a24b7fe65665?tpId=117&tqId=37727&rp=1&ru=%2Fta%2Fjob-code-high&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
public class 合并两个有序的数组 {
    public void merge(int A[], int m, int B[], int n) {
        if(n == 0){
            return;
        }
        if(m == 0){
            for(int i = 0;i < n;i++){
                A[i] = B[i];
            }
            return;
        }
        int[] newArr = new int[m + n];
        int indexA = 0;
        int indexB = 0;
        int index = 0;
        while(indexA < m && indexB < n){
            if(A[indexA] <= B[indexB]){
                newArr[index++] = A[indexA++];
            }else{
                newArr[index++] = B[indexB++];
            }
        }
        while(indexA < m){
            newArr[index++] = A[indexA++];
        }
        while(indexB < n){
            newArr[index++] = B[indexB++];
        }
        for(int i = 0;i < newArr.length;i++){
            A[i] = newArr[i];
        }
    }
}
