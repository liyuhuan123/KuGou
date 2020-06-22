package Learnjava_0622;

import java.util.HashMap;
import java.util.Map;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class excise<T> {
    //微信红包
    public static int getValue(int[] gifts, int n) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++) {
                map.put(gifts[i], map.getOrDefault(gifts[i], 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int temp = entry.getValue();
            if(temp > (n / 2)){
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3};
        System.out.println(getValue(arr,arr.length));
    }
    //链表分割
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead == null){
            return null;
        }
        ListNode small = null;
        ListNode big = null;
        ListNode smallLast = null;
        ListNode bigLast = null;
        for(ListNode cur = pHead;cur != null;cur = cur.next){
            if(cur.val < x){
                if(small == null){
                    small = cur;
                }else{
                    smallLast.next = cur;
                }
                smallLast = cur;
            }else{
                if(big == null){
                    big = cur;
                }else{
                    bigLast.next = cur;
                }
                bigLast = cur;
            }
        }
        if(small == null){
            return big;
        }else{
            smallLast.next = big;
            if(bigLast != null){
                bigLast.next = null;
            }
        }
        return small;
    }
}
