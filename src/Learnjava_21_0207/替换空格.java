package Learnjava_21_0207;

public class 替换空格 {
    //方法1:临时变量
    public String replaceSpace(StringBuffer str) {
        StringBuffer res = new StringBuffer();
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == ' '){
                res.append("%20");
            }else{
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
    //方法2:在原字符串直接修改
    public String replaceSpace2(StringBuffer str) {
        int count = 0;
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == ' '){
                count++;
            }
        }
        int newLength = str.length() + 2 * count;
        int oldIndex = str.length() - 1;
        int newIndex = newLength - 1;
        str.setLength(newLength);
        while(oldIndex >= 0 && newIndex >= 0){
            if(str.charAt(oldIndex) == ' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
                oldIndex--;
            }else{
                str.setCharAt(newIndex,str.charAt(oldIndex));
                newIndex--;
                oldIndex--;
            }
        }
        return str.toString();
    }
}
