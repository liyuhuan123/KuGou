package Learnjava_1014;

public class heap {
    //堆的向下调整
    public static void adjustDown(int[] array, int size, int index) {
        while(true){
            int leftIndex = index * 2 + 1;
            if(leftIndex >= size){
                return;
            }
            int minIndex = leftIndex;
            int rightIndex = leftIndex + 1;
            if(rightIndex < size && array[leftIndex] > array[rightIndex]){
                minIndex = rightIndex;
            }
            if(array[minIndex] >= array[index]){
                return;
            }
            if(array[minIndex] < array[index]){
                int temp = array[minIndex];
                array[minIndex] = array[index];
                array[index] = temp;
            }
            index = minIndex;
        }
    }
    //堆的向上调整（建堆的时候用）
    private static void adjustUp(int[] array,int size,int index){
        while(true){
            //1.判断index是不是树的根,如果是根，调整结束
            if(index == 0){
                break;
            }
            //2.找到index的父结点，
            int parentIndex = (index - 1) / 2;
            //3.比较父结点的值和index的值
            //4.只要父节点的值 <= index的值，调整结束
            if(array[parentIndex] <= array[index]){
                break;
            }
            //5.交换父结点的值和index位置的值
            int t = array[index];
            array[index] = array[parentIndex];
            array[parentIndex] = t;
            //6.把父结点看做index，继续这个大循环
            index = parentIndex;
        }
    }
}
