package Learnjava_0831;

public class Main {
    //二分查找
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int left = 0;
        int right = n - 1;
        while(left < right){
            if(a[left] == v){
                return left;
            }
            if(a[right] == v){
                return right;
            }
            int mid = left + (right - left) / 2;
            if(a[mid] == v){
                return mid;
            }else if(a[mid] < v){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return n + 1;
    }
}
