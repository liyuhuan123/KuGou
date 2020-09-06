package Lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    //localhost也可以
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9000;

    public static void main(String[] args) throws IOException {
        Socket client = new Socket(HOST,PORT);

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(),true);
        Scanner scanner = new Scanner(System.in);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    out.println("我是客户端小姐姐");
                }
            }
        }).start();

        String str;
        //阻塞等待客户端数据输入
        while((str = in.readLine()) != null){//io流在结束时，返回才是null
            System.out.println(str);
        }

    }
}
