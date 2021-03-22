package Learnjava_21_0322;
import java.util.*;
public class 提取优惠券码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            //A~z以及[\]^_’
            StringBuffer res = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                if (temp >= 'A' && temp <= 'z' || temp == '_'  || temp == '\\') {
                    res.append(temp);
                }else if(temp == '$'){
                    res.append('^');
                }
            }

            System.out.println(res.toString());
        }
    }
}
