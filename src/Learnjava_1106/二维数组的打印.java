package Learnjava_1106;
//链接:https://www.nowcoder.com/practice/6fadc1dac83a443c9434f350a5803b51?tpId=49&&tqId=29316&rp=1&ru=/activity/oj&qru=/ta/2016test/question-ranking
public class 二维数组的打印 {
    public int[] arrayPrint(int[][] arr, int n) {
        int[] result = new int[n * n];
        int index = 0;
        int startX = 0;
        int startY = n - 1;
        while(startX < n){
            int x = startX;
            int y = startY;
            while(x < n && y < n){
                result[index] = arr[x][y];
                x++;
                y++;
                index++;
            }
            if(startY > 0){
                startY--;
            }else{
                startX++;
            }
        }
        return result;

    }
}
