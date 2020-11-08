package Learnjava_1108;
//链接：https://www.nowcoder.com/practice/e016ad9b7f0b45048c58a9f27ba618bf?tpId=188&tqId=36321&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking
public class 寻找第K大 {
    //基于快排
    public int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a,0,n - 1);
        return a[n - K];
    }
    private void quickSort(int[] arr,int left,int right){
        if(right - left <= 0){
            return;
        }
        int index = partition(arr,left,right);
        quickSort(arr,left,index - 1);
        quickSort(arr,index + 1,right);
    }
    private int partition(int[] arr,int left,int right){
        int base = arr[right];
        int low = left;
        int high = right;
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
        return high;
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,3,7,6,8};
        寻找第K大 str = new 寻找第K大();
        System.out.println(str.findKth(arr,arr.length,3));
    }
}
