package Learnjava_1231;

public class 寻找第K大 {
    //https://www.nowcoder.com/practice/e016ad9b7f0b45048c58a9f27ba618bf?tpId=188&tqId=37022&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking
    public int findKth(int[] a, int n, int K) {
        // write code here
        //基于快排实现
        quickSort(a,0,n - 1);
        return a[n - K];
    }
    private void quickSort(int[] arr,int start,int end){
        if(start >= end){
            return;
        }
        int index = helper(arr,start,end);
        quickSort(arr,start,index - 1);
        quickSort(arr,index + 1,end);
    }
    private int helper(int[] arr,int start,int end){
        int right = end;
        int left = start;
        int base = arr[end];
        while(left < right){
            while(left < right && arr[left] <= base){
                left++;
            }
            while(left < right && arr[right] >= base){
                right++;
            }
            swap(arr,left,right);
        }
        swap(arr,left,end);
        return left;
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
