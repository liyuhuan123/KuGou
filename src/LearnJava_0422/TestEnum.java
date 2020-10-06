package LearnJava_0422;
enum Sex{
    //此处MALE这些内容的类型不再是int了，而是SEX类型
    MALE,
    FEMALE,
    OTHER
}
public class TestEnum {
    public static void main(String[] args) {
        Sex sex = Sex.MALE;
        if(sex == Sex.MALE){
            //针对男性做出一些处理...
    }
}        }

