package Learnjava_0901;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //缩写
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            List<Character> list = new ArrayList<>();
            int i = 1;
            list.add(str.charAt(0));
            while(i < str.length()){
                if(str.charAt(i) == ' '){
                    list.add(str.charAt(i + 1));
                }
                i++;
            }
            for(int j = 0;j < list.size();j++){
                System.out.print(list.get(j));
            }
        }
    }
}
