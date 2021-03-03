package Learnjava_21_0303;

import java.util.Arrays;

public class 堆排序 {
    public static void heapSort(int[] array){
        //先建立堆
        createHeap(array);
        //循环把堆顶元素交换到最后,并进行调整堆
        //循环次数length - 1,当堆中只剩一个元素的时候,也就一定是有序的
        for(int i = 0;i < array.length - 1;i++){
            //交换堆顶元素和堆的最后一个元素
            //堆的元素个数相当于array.length - i
            swap(array,0,array.length - 1 - i);
            //交换完成之后,要把最后一个元素从堆中删掉
            //堆的长度就进一步缩水了,array.length-i-1
            //数组中
            //[0,array.length-i-1)待排序区间
            //[array.length-i-1,array.length)已排序区间
            //[注意!!!]这个代码中的边界条件特别容易搞错~~ -1还是不减还是+1,最好带入数值来盐城
            //例如可以验证下i=0的时候,代码逻辑是否合理
            shiftDown(array,array.length - i - 1,0);
        }
    }
    private static void shiftDown(int[] array,int heapLength,int index){
        //这里是升序排序,建立的是大堆,大堆就需要找出左右子树中的最大值,再和根结点比较
        int parent = index;
        int child = 2 * parent + 1;
        while(child < heapLength){
            if(child + 1 < heapLength && array[child + 1] > array[child]){
                child = child + 1;
            }
            //条件结束意味着,child就已经是左右子树比较大的值的下标了
            if(array[child] > array[parent]){
                //需要交换两个元素
                swap(array,child,parent);
            }else{
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }
    public static void createHeap(int[] array){
        //从最后一个非叶子结点出发向前循环,一次进行向下调整
        //第一个 -1表示最后一个元素
        //再 -1 除以2表示最后一个叶子结点的父结点
        for(int i = (array.length - 1 - 1) / 2;i >= 0;i--){
            shiftDown(array,array.length,i);
        }
    }
    private static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8,4,2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
