package LearnJava_0830;

import java.util.*;

public class Test {
    //删除公共字符
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            List<Character> list = new ArrayList<>();
            Set<Character> set = new HashSet<>();
            for(int i = 0;i < str2.length();i++) {
                if(set.contains(str2.charAt(i))){
                    continue;
                }else{
                    set.add(str2.charAt(i));
                }
            }
            for(int i = 0;i < str1.length();i++){
                if(set.contains(str1.charAt(i))){
                    continue;
                }else{
                    list.add(str1.charAt(i));
                }
            }
            for(int i = 0;i < list.size();i++){
                System.out.print(list.get(i));
            }

        }
    }
}
