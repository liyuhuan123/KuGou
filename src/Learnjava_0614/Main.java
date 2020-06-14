package Learnjava_0614;

public class Main {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.out.println(str1 == str2);
    }
    //无缓存交换
    public int[] exchangeAB(int[] AB) {
        // write code here
        AB[0] = AB[0] ^ AB[1];
        AB[1] = AB[0] ^ AB[1];
        AB[0] = AB[0] ^ AB[1];
        return AB;
    }
    //生成格雷码
    public String[] getGray(int n) {
        // write code here
        if(n == 1){
            return new String[]{"0","1"};
        }
        String[] s1 = getGray(n - 1);
        String[] s2 = new String[2 * s1.length];
        for(int i = 0;i < s1.length;i++){
            s2[i] = "0" + s1[i];//首位添加0
            s2[i + s1.length] = "1" + s1[s1.length - 1 -i];
        }
        return s2;
    }
}
