package Learnjava_0606;


import java.util.*;

public class Main {
    //n个数里出现次数大于等于n/2的数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < arr.length;i++) {
                list.add(Integer.parseInt(arr[i]));
            }
            int n = list.size() / 2;
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i < list.size();i++){
                map.put(list.get(i),map.getOrDefault(list.get(i),1) + 1);
            }
//            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
//                int temp = map.get(entry);
//                if(temp >= n){
//                    System.out.println(temp);
//                    break;
//                }
//            }
            for(int i = 0;i < list.size();i++){
                int flag = 0;
                for(int j = 0;j < list.size();j++){
                    if(list.get(i) == list.get(j)){
                        flag++;
                    }
                }
                if(flag >= list.size() / 2){
                    System.out.println(list.get(i));
                    break;
                }
            }
        }
        sc.close();
    }
}
