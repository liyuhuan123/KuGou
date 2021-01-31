package Learnjava_21_0131.Learnjava_0131;

import java.util.*;

public class 大整数排序{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            String[] str = new String[n];
            for(int i = 0; i < str.length; i++) {
                str[i] = sc.next();
            }
            quickSort(str,0,str.length-1);
            for(String s : str) {
                System.out.println(s);
            }
        }
    }
    private static void quickSort(String[] str, int left, int right) {
        if(left > right) {
            return;
        }
        int i = left,j = right;
        String tmp = str[left];
        while (i != j) {
            while (i < j && !find(tmp,str[j],0)) {
                j--;
            }
            while (i < j && find(tmp,str[i],1)) {
                i++;
            }
            if(i < j) {
                String tmep = str[i];
                str[i] = str[j];
                str[j] = tmep;
            }
        }
        str[left] = str[i];
        str[i] = tmp;
        quickSort(str,left,i-1);
        quickSort(str,i+1,right);
    }

    private static boolean find(String tmp, String s,int flag) {
        if(tmp.length() > s.length()) {
            return true;
        }else if(tmp.length() == s.length()) {
            if(tmp.equals(s)) {
                if(flag == 0) {
                    return false;
                } else {
                    return true;
                }
            }
            for (int i = 0; i < tmp.length(); i++) {
                if(tmp.charAt(i) > s.charAt(i)) {
                    return true;
                }
                if(tmp.charAt(i) < s.charAt(i)) {
                    return false;
                }
            }
        }
        return false;
    }
}

