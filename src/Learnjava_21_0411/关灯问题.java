package Learnjava_21_0411;
import java.util.*;
public class 关灯问题 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] array = new int[m];
            for(int i = 0;i < m;i++){
                array[i] = sc.nextInt();
            }
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0;i < n;i++){
                list.add(1);
            }
            int[] res = new int[n];
            int temp;
            for(int i = 0;i < m;i++){
                temp = array[i];
                for(int j = temp;j < n + 1;j++){
                    if(res[j - 1] == 0 && list.get(j - 1) == 1){
                        res[j - 1] = i + 1;
                    }
                }
            }
            for(int e : res){
                System.out.print(e + " ");
            }
        }
    }
}
