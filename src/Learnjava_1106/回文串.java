package Learnjava_1106;

import java.util.Scanner;
//https://www.nowcoder.com/questionTerminal/655a43d702cd466093022383c24a38bf
//给定一个字符串，问是否能通过添加一个字母将其变为回文串。
public class 回文串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(helper(str) == true ? "YES" : "NO");
        }
    }
    //如果长度为n的字符串添加一个字符能称为回文串，那么删除一个字符也能称为回文，
    // 因为这两个字符是对称位置，如果删除的是中间字符的话，
    // 那么原字符串本身必是回文，如果删除的是两端字符的话，那么长度为n-1的两个子串必有一个也是回文
    private static boolean helper(String str){
        if(isHuiWen(str.substring(0,str.length() - 1)) || isHuiWen(str.substring(1,str.length()))){
            return true;
        }else{
            return false;
        }
    }
    private static boolean isHuiWen(String str){
        return new StringBuilder(str).reverse().toString().equals(str);
    }
}
