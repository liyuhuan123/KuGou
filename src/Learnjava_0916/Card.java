package Learnjava_0916;

public class Card {
    public String suit;//花色
    public int rank;//分值
    public Card(String suit,int rank){
        this.suit = suit;
        this.rank = rank;
    }
    @Override
    public String toString(){
        return String.format("[%s %d]",suit,rank);
    }
}
