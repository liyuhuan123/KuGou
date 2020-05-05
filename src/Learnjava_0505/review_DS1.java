package Learnjava_0505;

import java.util.Arrays;
import java.util.Stack;

public class review_DS1 {
    private static void insertSort(int[] array){
        for(int i = 1;i < array.length;i++){
            int v = array[i];
            int j = i - 1;
            for(;j >= 0;j--){
                if(array[j] > v){
                    array[j + 1] = array[j];
                }else{
                    break;
                }
            }
            array[j + 1] = v;
        }
        System.out.println(Arrays.toString(array));

    }
    private static void shellSort(int[] array){
        int gap = array.length;
        while(gap > 1){
            shellSort_helper(gap,array);
            gap /= 2;
        }
        shellSort_helper(1,array);
        System.out.println(Arrays.toString(array));
    }

    private static void shellSort_helper(int gap, int[] array) {
        for(int i = gap;i < array.length;i++){
            int v = array[i];
            int j = i - gap;
            for(;j >= 0;j -= gap){
                if(array[j] > v){
                    array[j + gap] = array[j];
                }else{
                    break;
                }
            }
            array[j + gap] = v;
        }
    }
    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            for (int j = i + 1; j > i;j--) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
    private static void bubbleSort(int[] array){
        for(int i = 0;i < array.length;i++){
            for(int j = array.length - 1;j > i;j--){
                if(array[j] > array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
    private static void heapSort(int[] array){

    }
    private static void quickSort(int[] array){
        //辅助完成递归过程
        //为了代码简单，区间设定成前闭后闭
        quickSortHelper(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right){
            //区间中有0个或者一个元素，此时不需要排序
            return;
        }
        //针对[left，right）区间进行整理
        //index返回值就是整理完毕后left和right的重合位置，知道了这个位置
        //才能进一步进行递归,
        int index = partition(array,left,right);
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array,index + 1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        //取最右侧元素为基准值
        int base = array[right];
        while(i < j){
            //从左往右找到比基准值大的元素
            while(i < j && array[i] <= base){
                i++;
            }
            //当上面的循环结束时，i要么和j重合要么就指向一个大于base的值
            //从右往左找比基准值小的元素
            while(i < j && array[j] >= base){
                j--;
            }
            //当上面的循环结束时，i要么和j重合要么就指向一个小于base的值
            //交换i和j的值
            swap(array,i,j);
        }
        //当i和j重合的时候，最后一步，要把重合位置的元素和基准值交换
        swap(array,i,right);
        return i;

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private static void quickSortByLoop(int[] array){
        //借助栈，模拟递归过程
        //stack用来存放数组下标，通过下标来表示接下来要处理的区间是啥
        Stack<Integer> stack = new Stack<>();
        //初始情况下，先把右侧边界下标入栈，再把左侧下标入栈，左右下标
        //仍然构成前闭后闭区间
        stack.push(array.length - 1);
        stack.push(0);
        while(!stack.isEmpty()){
            //这个取元素的顺序要和push的顺序正好相反
            int left = stack.pop();
            int right = stack.pop();
            if(left >= right){
                //区间中只有一个或0个元素，不需要整理
                return;
            }
            //通过partition把区间整理成以基准值为中心，左侧元素
            //小于等于基准值，右侧元素大于等于基准值的形式
            int index = partition(array,left,right);
            //准备处理下个区间
            //[index + 1,right]基准值右侧区间
            stack.push(right);
            stack.push(index + 1);
            //[left,index - 1]基准值左侧区间
            stack.push(index - 1);
            stack.push(left);
        }


    }
    //[low,mid)有序区间
    //[mid,high)有序区间
    //把这两个有序区间合并成一个有序区间
    public static void merge(int[] array,int low,int mid,int high){
        int[] output = new int[high - low];
        int outputIndex = 0;//记录当前output数组中放入多少个元素了
        int cur1 = low;
        int cur2 = mid;
        while(cur1 < mid && cur2 < high){
            //这里写成小于等于才能保证稳定性
            if(array[cur1] <= array[cur2]){
                output[outputIndex] = array[cur1];
                outputIndex++;
                cur1++;
            }else{
                output[outputIndex] = array[cur2];
                outputIndex++;
                cur2++;
            }
        }
        //上面的循环结束的时候，肯定是cur1或者cur2有一个先到达末尾，另一个还剩下一些内容
        while(cur1 < mid){
            output[outputIndex] = array[cur1];
            outputIndex++;
            cur1++;
        }
        while(cur2 < high){
            output[outputIndex] = array[cur2];
            outputIndex++;
            cur2++;
        }
        //把output中的元素再搬回原来的数组
        for(int i = 0;i < high - low;i++){
            array[low + 1] = output[i];
        }
    }
    private static void mergeSort(int[] array){
        mergeSortHelper(array,0,array.length);
    }
    //[low,high)前闭后开区间，两者差值小于等于1，区间中就只有一个或者0个元素
    private static void mergeSortHelper(int[] array, int low, int high) {
        if(high - low <= 1){
            return;
        }
        int mid = (low + high) / 2;
        //这个方法执行完，就认为low,mid已经排序OK
        mergeSortHelper(array,low,mid);
        //这个方法执行完，就认为mid，high也已经排序OK
        mergeSortHelper(array,mid,high);
        //当把左右区间已经归并完了，说明左右去家已经是有序区间了
        //接下来就可以针对两个有序区间进行合并了
        merge(array,low,mid,high);

    }
    private static void mergeSortByLoop(int[] array){
        //引入一个gap变量进行分组
        //当gap为1的时候，[0] [1]进行合并，[2] [3]进行合并，[4] [5]进行合并，[6] [7]进行合并
        //当gap为2的时候，[0,1]进行合并，[2,3]进行合并，[4,5]进行合并和[6,7]进行合并
        //当gap为4的时候，[0,1,2,3]和[4,5,6,7]进行合并
        for(int gap = 1;gap < array.length;gap *= 2){
            //接下来进行具体合并
            //下面的循环执行一次，就完成了一次相邻两个组的合并
            for(int i = 0;i < array.length;i += 2*gap){
                //当前相邻组
                //[beg,mid)
                //[mid,end)
                //beg => i
                //mid => i + gap
                //end => i + 2 * gap
                int beg = i;
                int mid = i + gap;
                int end = i + 2 * gap;
                if(mid > array.length){
                    mid = array.length;
                }
                if(end > array.length){
                    end = array.length;
                }
                merge(array,beg,mid,end);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
//        insertSort(array);
//        shellSort(array);
//        selectSort(array);
//        bubbleSort(array);
//        quickSort(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));

    }

}
