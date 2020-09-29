package Learnjava_0929;
//链接：https://leetcode-cn.com/problems/add-digits/submissions/
public class 各位相加 {
    public int addDigits(int num) {
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        while(sum >= 10){
            int s = 0;
            while(sum != 0){
                s += sum % 10;
                sum /= 10;
            }
            sum = s;
        }
        return sum;
    }
}
