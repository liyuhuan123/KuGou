package Learnjava_1007;

import org.junit.Test;

import java.io.*;

public class FileOperatorTest {
    @Test
    public void fileRead_1() throws IOException {
        //文件读操作
        //字节流转换为字符流，需要使用字节符转换流
        //转换流可以设置编码：java文件的编码格式，文件编码格式
        //InputStreamReader：输入的字节符转换流，或OutputStreamWriter：输出的字节字符转换流
        FileInputStream fis = new FileInputStream(
                new File("E:\\KuGou\\res\\info.txt"));//现在还是一个二进制流
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
        //字符流按行读取
//        String line;
//        while((line = br.readLine()) != null){
//            System.out.println(line);
//        }
        //字符流按字符数组读取
//        char[] chars = new char[1024];
//        int len;
//        while((len = br.read(chars,0,1024)) != -1){
//            String str = new String(chars,0,len);
//            System.out.println(str);
//        }
        char[] chars = new char[1024];
        int len;
        while((len = br.read(chars)) != -1){
            String str = new String(chars,0,len);
            System.out.println(str);
        }
    }
    @Test
    public void testRead_2() throws IOException {
        FileInputStream fis = new FileInputStream(new File("E:\\KuGou\\res\\info.txt"));
        //按字节读取
        byte[] bytes = new byte[1024];
        int len;
        while((len = fis.read(bytes)) != -1){
            String str = new String(bytes,0,len);
            System.out.println(str);
        }
    }

    @Test
    public void testWrite1() throws IOException {
        //文件写操作
        FileOutputStream fos = new FileOutputStream(
                new File("E:\\KuGou\\res\\info.txt"));
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
        //使用缓冲流，输出的时候，要进行flush刷新缓冲区，否则不会真实的输出数据到目的设备
        br.write("1.jidewif");//write写数据到系统内存缓冲区
        br.write("2.hdwihu");
        br.write("3.hdwuiebfhc");
        br.flush();//缓冲区刷新，发送数据到目的设备
    }
    @Test
    public void coryFile() throws IOException {
        //文件复制操作
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(new File("E:\\KuGou\\res\\info.txt"));
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream(new File("E:\\KuGou\\res\\info1.txt"));
            bos = new BufferedOutputStream(fos);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                bos.write(bytes);
                bos.flush();
            }
        }finally{//IO流的操作完成之后，一定要释放资源，顺序是根据依赖关系B依赖A，反向释放（先释放B）
            if(bis != null)
                bis.close();
            if(fis != null)
                fis.close();
            if(bos != null){
                bos.close();
            }
            if(fos != null){
                fos.close();
            }

        }
    }

}
