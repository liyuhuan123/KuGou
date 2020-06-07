package Learnjava_0607;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//服务端
public class Server {
    public static int PORT = 9999;
    //创建一个线程池，大小为4
    //ServerSocket.accept是阻塞式方法，使用固定大小线程池会存在问题
    private static ExecutorService POOL = Executors.newFixedThreadPool(4);
    public static void main(String[] args) throws IOException {
        //启动了服务端程序:netstat -ano|findstr"9999",可以显示进程的pid
        //在任务管理器中通过pid查找到进程
        //pid是系统管理进程的方式，数据还是发送到端口中，pid是进程启动随机分配的
        //网络传输数据，使用端口号来定位程序，指定端口号启动程序就保证了服务器是固定端口
        ServerSocket server = new ServerSocket(PORT);
        //阻塞等待客户端连接，有新的连接来，往下执行
        Socket client = server.accept();
        POOL.submit(new ServerTask(client));
    }
    //把输入输出流放到这个任务类里处理
    private static class ServerTask implements Runnable{
        private Socket client;

        public ServerTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            //处理client中的输入输出流，也就是发送/读取网络数据包
            try{
                InputStream is = client.getInputStream();
                InputStreamReader isr = new InputStreamReader(is,"UTF-8");
                BufferedReader br = new BufferedReader(isr);

                OutputStream os = client.getOutputStream();
                PrintWriter pw = new PrintWriter(os,true);

                String line;
                //输入字节流没有结束
                while((line = br.readLine()) != null){
                    System.out.println("接受客户端数据：" + line);
                    pw.println("响应 ：" + line);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
