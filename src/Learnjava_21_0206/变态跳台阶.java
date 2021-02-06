package Learnjava_21_0206;
//链接:https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
/**
 * 问题描述:
 * 一只青蛙一次可以跳上一级台阶,也可以跳上2级台阶.....它也可以跳上n级
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法
 * 分析:
 * 状态F(i):跳上i级台阶的方法个数
 * 转移方程
 * F(i)
 * F(1):{1}
 * F(2):{1,1}  {2}
 * F(3):{1,1,1}  {2,1}  {1,2}  {3}
 * F(4):{1,1,1,1}  {1,3}  {3,1}  {1,1,2}  {1,2,1}  {2,2}  {2,1,1}  {4}
 * .......
 *
 */
public class 变态跳台阶 {
    public int JumpFloorII(int target) {
        if(target == 0){
            return 0;
        }
        int ret = 1;
        for(int i = 2;i <= target;i++){
            ret *= 2;
        }
        return ret;
    }
    public int JumpFloorII2(int target) {
        if(target == 0){
            return 0;
        }
        return 1 << (target - 1);
    }
}
