package Learnjava_21_0121;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class 链式A加B {
    public ListNode plusAB(ListNode a, ListNode b) {
        ListNode head = null;
        ListNode tail = head;
        boolean flag = false;
        while(a != null && b != null){
            int temp = a.val + b.val;
            if(head == null){
                if(flag){
                    head = new ListNode(1);
                    tail = head;
                }
                else{
                    head = new ListNode(0);
                    tail = head;
                }
            }
            else{
                if(flag){
                    tail.next = new ListNode(0);
                    temp += 1;
                    tail = tail.next;
                }
                else{
                    tail.next = new ListNode(0);
                    tail = tail.next;
                }
            }

            if(temp >= 10){
                temp -= 10;
                flag = true;
            }
            else{
                flag = false;
            }
            tail.val += temp;
            a  = a.next;
            b = b.next;
        }
        while(a != null){
            int temp = a.val;
            if(flag){
                tail.next = new ListNode(0);
                temp += 1;
                tail = tail.next;
            }
            else{
                tail.next = new ListNode(0);
                tail = tail.next;
            }

            if(temp >= 10){
                temp -= 10;
                flag = true;
            }
            else{
                flag = false;
            }
            tail.val += temp;
            a = a.next;
        }
        while(b != null){
            int temp = b.val;
            if(flag){
                tail.next = new ListNode(0);
                temp += 1;
                tail = tail.next;
            }
            else{
                tail.next = new ListNode(0);
                tail = tail.next;
            }

            if(temp >= 10){
                temp -= 10;
                flag = true;
            }
            else{
                flag = false;
            }
            tail.val += temp;
            b = b.next;
        }
        if(a == null&&b == null){
            if(flag){
                tail.next = new ListNode(1);
                tail = tail.next;
            }
        }
        return head;
    }


}
