package Learnjava_21_0418;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < str.length();i++){
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    list.add(Integer.valueOf(String.valueOf(str.charAt(i))));
                }
            }
            int[] arr = new int[list.size()];
            for(int i = 0;i < arr.length;i++){
                arr[i] = list.get(i);
            }
            List<List<Integer>> ans = new ArrayList<>();
            for(int i = 1;i < list.size();i++){
                List<Integer> temp = new ArrayList<>();
                rotate(arr,i,temp);
                ans.add(temp);
            }
            for(int i = 0;i < ans.size();i++){
                Collections.sort(ans.get(i));
            }
            Collections.sort(ans,new Comparator<List<Integer>>(){
                public int compare(List<Integer> a,List<Integer> b){
                    if(a.get(1) == b.get(1)){
                        //若a[0] b[0]值相同则比较a[1] b[1]，按升序
                        return a.get(0) - b.get(0);
                    }else{
                        return a.get(1) - b.get(1);
                    }
                }
            });
            System.out.println(ans.get(0));
        }
    }
    public static void rotate(int[] array,int k,List<Integer> ans){
        int length = array.length;
       int[] newArray = new int[length];
        for(int i = 0; i < length; i++) {
            int newPosition = (i + k) % length;
            newArray[newPosition] = array[i];
        }
        int i = 0;
        while(i < array.length){
            ans.add(newArray[i]);
            i++;
        }
    }
}
