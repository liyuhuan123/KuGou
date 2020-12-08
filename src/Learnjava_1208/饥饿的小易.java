package Learnjava_1208;


import java.util.*;

public class 饥饿的小易 {
    final static long ANS = 1000000007L;
    final static int POWER = 100000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long num = sc.nextLong();
            System.out.println(helper(num));
        }
    }
    private static long helper(long x) {
        //存储已访问的点
        Map<Long,Integer> map = new HashMap<>();
        //存储待访问的点
        Queue<Long> queue=new LinkedList<>();
        map.put(x,0);
        queue.add(x);
        while (!queue.isEmpty()){
            long d;
            Long top=queue.poll();
            if (map.get(top)> POWER) {
                break;
            }
            if(top==0){
                return map.get(top);
            }
            d=((top<<2)+3)% ANS;
            if(d==0){
                return map.get(top)+1;
            }
            if(!map.containsKey(d)){
                queue.add(d);
                map.put(d,map.get(top)+1);
            }
            d=((top<<3)+7)% ANS;
            if (d==0){
                return map.get(top)+1;
            }
            if(!map.containsKey(d)) {
                queue.add(d);
                map.put(d,map.get(top)+1);
            }
        }
        return -1L;
    }
}
