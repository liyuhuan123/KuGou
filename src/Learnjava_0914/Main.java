package Learnjava_0914;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class Main {
    //速算机器人https://leetcode-cn.com/problems/nGK0Fy/
    public int calculate(String s) {
        int x = 1,y = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == 'A'){
                x = 2 * x + y;
            }else{
                y = 2 * y + x;
            }
        }
        return x + y;
    }
    //删除链表中的结点
    // https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
    public void deleteNode(ListNode node) {

    }
    //整数的各位积和之差
    // https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int count = 1;
        while(n > 0){
            sum += (n % 10);
            count *= (n % 10);
            n /= 10;
        }
        return count - sum;
    }
    //将数字变成0的操作次数
    // https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
    public int numberOfSteps (int num) {
        int count = 0;
        while(num > 0){
            while(num % 2 == 0){
                num /= 2;
                count++;
            }
            while(num % 2 == 1){
                num -= 1;
                count++;
            }
        }
        return count;
    }
}
