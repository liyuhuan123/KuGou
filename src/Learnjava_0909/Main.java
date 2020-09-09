package Learnjava_0909;

public class Main {
//统计位数为偶数的数字
// https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits/
public int findNumbers(int[] nums) {
int count = 0;
for(int i = 0;i < nums.length;i++){
    int temp = 0;
    while(nums[i] != 0){
        nums[i] /= 10;
        temp++;
    }
    if(temp % 2 == 0){
        count++;
    }
}
return count;

}
//在既定时间做作业的学生人数
// https://leetcode-cn.com/problems/number-of-students-doing-homework-at-a-given-time/
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
    int count = 0;
    for(int i = 0;i < startTime.length;i++){
        if(startTime[i] > (queryTime)){
            continue;
        }else if(endTime[i] >= queryTime){
            count++;
        }else if(endTime[i] < queryTime){
            continue;
        }
    }
    return count;
    }
    //剪绳子
    // https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
    public int cuttingRope(int n) {
    if(n <= 3){
        return 1 * (n - 1);
    }
    int result = 1;
    if(n % 3 == 1){
        result = result * 4;
        n = n - 4;
    }else if(n % 3 == 2){
        result = result * 2;
        n = n - 2;
    }
    while(n != 0){
        result = result * 3;
        n = n - 3;
    }
    return result;
    }
}
