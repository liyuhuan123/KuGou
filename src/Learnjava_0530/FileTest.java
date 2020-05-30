package Learnjava_0530;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest {
    public static void main(String[] args) {
        //文件相对路径和绝对路径
        //绝对路径：全路径.相对路径:./(当前目录).../(上一级目录)
        //java项目在idea中的编译路径
        File file = new File("E:\\KuGou\\data\\随便.txt");
        System.out.println(file.exists());//true
        File f2 = new File("../data/随便.txt");
        System.out.println(f2.exists());//false
        //怎么查看当前java代码的路径
        File f3 = new File("");
        System.out.println(f3.getAbsolutePath());//获取绝对路径
        File f4 = new File("data/随便.txt");//file类写相对路径不建议在真实的项目中使用
        System.out.println(f4.exists());//true,文件知否存在
        System.out.println(f4.getPath());//获取路径
        System.out.println(f4.lastModified());//上次修改时间
        File f5 = new File("E:\\KuGou\\data");
        //返回目录下一级的子文件/子文件夹数组
        File[] children = f5.listFiles();
        for(File child : children){
            System.out.println(child.getName());
        }
    }
    //递归获取目录下所有的子文件和子文件夹
    public static List<File> list(File f){
        List<File> files = new ArrayList<>();
        if(f.isFile()){
            files.add(f);
        }else{
            //下一级子文件和子文件夹
            File[] children = f.listFiles();
            for(File child : children){
                List<File> subs = list(child);
                files.addAll(subs);
            }
        }
        return files;
    }
}
