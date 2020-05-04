package Learnjava_0504;

public class Card {
    public int rank;//牌面值
    public String suit;//花色
    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }
}
