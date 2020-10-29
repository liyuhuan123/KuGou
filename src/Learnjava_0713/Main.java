package Learnjava_0713;

public class Main {
        public String ReverseSentence(String str) {
            if(str==null||str.trim().equals("")){
                return str;
            }
            String str1=reverse(str);
            String[] strs = str1.split(" ");
            if(strs==null)
                return str;
            String result = "";
            for(int i=0;i<strs.length;i++){
                strs[i]=reverse(strs[i]);
                result=result+strs[i];
                if(i!=strs.length-1){
                    result+=" ";
                }
            }
            result.trim();
            return result;
        }
        public String reverse(String str){
            char[] a = str.toCharArray();
            for(int i=0;i<(a.length)/2;i++){
                char temp = a[i];
                a[i]=a[a.length-1-i];
                a[a.length-1-i]=temp;
            }
            return String.valueOf(a);
        }

}
