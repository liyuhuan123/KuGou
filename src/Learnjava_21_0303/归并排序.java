package Learnjava_21_0303;

import java.util.Arrays;

public class 归并排序 {
    public static void mergeSort(int[] arr){
        mergeSortHelper(arr,0,arr.length);
    }
    //[low,high)这里的区间采用前闭后开区间,两者差值小于等于1,区间中只有零个元素或者一个
    public static void mergeSortHelper(int[] arr,int low,int high){
        if(high - low <= 1){
            return;
        }
        int mid = (low + high) / 2;
        //这个方法执行完,就认为[low,mid)已经排序ok
        mergeSortHelper(arr,low,mid);
        //这个方法执行完,就认为[mid,high)已经排序ok
        mergeSortHelper(arr,mid,high);
        //当把左右区间已经归并排序完了,说明左右区间已经是有序区间了
        //接下来就可以针对两个有序区间进行合并了
        merge(arr,low,mid,high);
    }
    //[low,high)这里的区间采用前闭后开区间
    //[low,mid) 有序区间
    //[mid,high) 有序区间
    //把这两个有序区间合并成一个有序区间
    public static void merge(int[] arr,int low,int mid,int high){
        int[] output = new int[high - low];
        int outputIndex = 0;//记录当前output数组中被放入多少个元素了
        int cur1 = low;
        int cur2 = mid;
        while(cur1 < mid && cur2 < high){
            //这里写成小于等于才能保证稳定性
            if(arr[cur1] <= arr[cur2]){
                output[outputIndex] = arr[cur1];
                outputIndex++;
                cur1++;
            }else{
                output[outputIndex] = arr[cur2];
                outputIndex++;
                cur2++;
            }
        }
        //当上面的循环结束的时候,肯定是cur1或者cur2先到达末尾,另一个还剩下一些内容
        //把剩下的内容都一股脑拷贝到output中
        while(cur1 < mid){
            output[outputIndex] = arr[cur1];
            outputIndex++;
            cur1++;
        }
        while(cur2 < high){
            output[outputIndex] = arr[cur2];
            outputIndex++;
            cur2++;
        }
        //把output中的元素搬运回原来的数组
        for(int i = 0;i < high - low;i++){
            arr[low + i] = output[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8,4,2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
