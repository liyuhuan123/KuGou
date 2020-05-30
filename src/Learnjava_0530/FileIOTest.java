package Learnjava_0530;

import java.io.*;

public class FileIOTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        try {
            //第一种方式，使用FileInputStream+绝对路径
            fis = new FileInputStream(new File("E:\\KuGou\\data\\随便.txt"));
            //第二种方式，使用classLoader+相对路径(推荐)
            //fis = this.getClass().getResourceStream("随便.txt");
            byte[] bytes = new byte[1024];
            int len;
            while((len = fis.read(bytes)) != -1){
                String s = new String(bytes,0,len);
                System.out.println(s);
            }
        } finally {
            if(fis != null){
                fis.close();
            }
        }
//        FileReader reder = new FileReader("E:\\KuGou\\data\\随便.txt");
//        char[] chars = new char[1024];
//        int len;
//        while((len = fis.read(chars)) != -1){
//            String s = new String(chars,0,len);
//            System.out.println(s);
//        }
    }
}
