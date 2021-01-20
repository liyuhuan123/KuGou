package learnjava_21_0120;

import java.util.*;
public class 最难的问题{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    sb.append(" ");
                    continue;
                }
                int a = c - 'A';
                if (a < 5) {
                    char tmp = (char) ('Z' - 4 + a);
                    sb.append(tmp);
                } else {
                    char tmp2 = (char) (c - 5);
                    sb.append(tmp2);
                }
            }
            System.out.println(sb.toString());
        }
    }
}