package Learnjava_1122;
//基于快排
public class 寻找第K大 {
    public int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a,0,n - 1);
        return a[n - K];
    }

    private void quickSort(int[] a, int left, int right) {
        if(left >= right){
            return;
        }
        int index = helper(a,left,right);
        quickSort(a,left,index - 1);
        quickSort(a,index + 1,right);
    }
    private int helper(int[] arr,int left,int right){
        int low = left;
        int high = right;
        int base = arr[right];
        while(low < high){
            while(low < high && arr[low] <= base){
                low++;
            }
            while(low < high && arr[high] >= base){
                high--;
            }
            swap(arr,low,high);
        }
        swap(arr,low,right);
        return low;
    }
    private void swap(int[] arr,int low,int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
