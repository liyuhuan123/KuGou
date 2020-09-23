package Learnjava_0923;

public class Main {
    //山脉数组的峰顶索引
    // https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/submissions/
    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length < 3){
            return -1;
        }
        int index = 0;
        while(index < arr.length - 1){
            if(arr[index] < arr[index + 1]){
                index++;
            }else{
                break;
            }
        }
        return index;
    }
}
