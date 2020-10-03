package Learnjava_1003;

import java.util.Arrays;

//链接： https://leetcode-cn.com/problems/sort-array-by-parity-ii/
public class 按奇偶排序数组II {
    //方法1：超出时间限制
    public static int[] sortArrayByParityII(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while(left < right){
            if(left % 2 == 0){
                if(A[left] % 2 != 0){
                    while(left < right){
                        if(right % 2 != 0 && A[right] % 2 == 0){
                            int temp = A[left];
                            A[left] = A[right];
                            A[right] = temp;
                        }else{
                            right--;
                        }
                    }
                }else{
                    left++;
                }
            }else{
                if(A[left] % 2 == 0){
                    while(left < right){
                        if(right % 2 == 0 && A[right] % 2 != 0){
                            int temp = A[left];
                            A[left] = A[right];
                            A[right] = temp;
                        }else{
                            right--;
                        }
                    }
                }else{
                    left++;
                }
            }
        }
        return A;
    }
    //方法2：
    public static int[] sortArrayByParityII2(int[] A) {
        if(A.length == 0 || A == null){
            return new int[0];
        }
        int pre = 0;
        int cur = 1;
        int[] res = new int[A.length];
        for(int temp : A){
            if(temp % 2 == 0){
                res[pre] = temp;
                pre += 2;
            }else{
                res[cur] = temp;
                cur += 2;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int A[] = {4,2,5,7};
        System.out.println(Arrays.toString((sortArrayByParityII2(A))));
    }
}
