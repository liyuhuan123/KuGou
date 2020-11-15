package Learnjava_1114;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int T = sc.nextInt();
            for(int i = 0;i <= T;i++){
                String URL = sc.nextLine();
                helper(URL);
            }
        }
    }
    private static void helper(String url) throws MalformedURLException {
        //startsWith()方法用于检测字符串是否以指定的前缀开始
        if(!url.startsWith("http") && !url.startsWith("https")){
            url = "http://"+url;
        }
        //url代表一个绝对地址,URL对象直接指向这个资源
        URL netUrl = new URL(url);
        String host = netUrl.getHost();//返回主机名
        System.out.println(host);
    }
}
