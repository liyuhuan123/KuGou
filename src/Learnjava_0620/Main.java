package Learnjava_0620;

import java.util.Scanner;

//DNA序列
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int n = sc.nextInt();
            int max = 0;
            int index = 0;
            for(int i = 0;i <= str.length() - n;i++){
                int count  = 0;
                for(int j = i;j < i + n;j++){
                    if(str.charAt(j) == 'C' || str.charAt(j) == 'G'){
                        count++;
                    }
                    if(count > max){
                        max = count;
                        index = i;
                    }
                }
            }
            System.out.println(str.substring(index,index + n));
        }
    }
}
