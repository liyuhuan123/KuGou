package Learnjava_1108;

import java.util.ArrayList;
//链接：https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=188&tqId=36321&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking
public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k > input.length){
            return list;
        }
        quickSort(input,0,input.length - 1);
        for(int i = 0;i < k;i++){
            list.add(input[i]);
        }
        return list;
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
        int baseNum = arr[right];
        int low = left;
        int high = right;
        while(low < high){
            while(low < high && arr[low] <= baseNum){
                low++;
            }
            while(low < high && arr[high] >= baseNum){
                high--;
            }
            swap(arr,low,high);
        }
        swap(arr,low,right);
        return low;
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
