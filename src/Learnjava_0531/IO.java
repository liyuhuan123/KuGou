package Learnjava_0531;

import com.sun.xml.internal.ws.message.stream.OutboundStreamHeader;

import java.io.*;

public class IO {
    public static void main(String[] args) throws IOException {
//        //覆盖的形式
//        FileOutputStream fos = new FileOutputStream("E:\\KuGou\\data\\随便.txt");
//        //追加到文件末尾
//        //FileOutputStream fos = new FileOutputStream("E:\\KuGou\\data\\随便.txt");
//        PrintWriter pw = new PrintWriter(fos,true);//自动刷新，不用后面的flush方法，没有true，则是手动刷新
//        pw.println("追加1");
//        pw.println("追加2");
//        pw.println("追加3");
//        pw.flush();//手动刷新缓冲区
        FileOutputStream fos = new FileOutputStream("E:\\KuGou\\data\\随便.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("追加1");
        bw.newLine();
        bw.write("追加2");
        bw.newLine();
        bw.write("追加3");
        bw.newLine();
        bw.flush();
    }
}
