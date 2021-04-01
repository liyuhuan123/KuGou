package Learnjava_21_0401;

import java.util.Scanner;

public class 提取优惠券 {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String str = sc.nextLine();
                StringBuilder res = new StringBuilder();
                for(int i = 0;i < str.length();i++){
                    char temp = str.charAt(i);
                    if((temp >= 'A' && temp <= 'z') || temp == '^' || temp == '\\' || temp == '\'' || temp == '$'){
                        if(temp == '$'){
                            res.append('^');
                        }else{
                            res.append(temp);
                        }
                    }
                }
                System.out.println(res.toString());
            }
        }
}
