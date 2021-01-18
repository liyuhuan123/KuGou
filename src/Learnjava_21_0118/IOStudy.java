package Learnjava_21_0118;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IOStudy {
    public static void main(String[] args) {
        File dir = new File("F:\\测试用例练习");
        List<File> files = listDir2(dir);
        //jdk1.8集合框架使用Stream操作,可以lambda表达式
        files.stream()
                .forEach(System.out::println);
    }
    public static List<File> listDir(File dir){
        List<File> list = new ArrayList<>();
        if(dir.isFile()){//效率不太好的地方:如果是文件,返回一个list只存放一个元素
            list.add(dir);
        }else if(dir.isDirectory()){
            File[] children = dir.listFiles();
            if(children != null){
                for(File child :children){
                    List<File> files = listDir(child);
                    list.addAll(files);
                }
            }
        }
        return list;
    }
    public static List<File> listDir2(File dir){
        List<File> list = new ArrayList<>();
        if(dir.isDirectory()){
            //获取目录下一级的子文件,子文件夹
            File[] children = dir.listFiles();
            if(children != null){
                for(File child : children){
//                    //返回的文件 不包含文件夹
//                    if(child.isDirectory()){//如果是子文件夹,递归调用获取
//                        list.addAll(listDir2(child));
//                    }else{
//                        list.add(child);
//                    }
                    //如果要包含
                    list.add(child);
                    if(child.isDirectory()){
                        list.addAll(listDir2(child));
                    }
                }
            }
        }
        return list;
    }
}
