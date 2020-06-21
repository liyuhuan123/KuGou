package Learnjava_0621;

public class Main {
    public static void main(String[] args) {

    }
    //子串判断
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] result = new boolean[n];
        for(int i = 0;i < n;i++){
            if(s.contains(p[i])){
                result[i] = true;
            }else{
                result[i] = false;
            }
        }
        return result;
    }
}
