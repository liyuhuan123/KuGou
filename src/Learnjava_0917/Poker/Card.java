package Learnjava_0917.Poker;

public class Card {
    public String suit;//花色
    public int rank;//点数
    public Card(String suit,int rank){
        this.suit = suit;
        this.rank = rank;
    }
    @Override
    public String toString(){
        return String.format("[%s %d]",suit,rank);
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || !(o instanceof Card)){
            return false;
        }
        Card card = (Card)o;
        return rank == card.rank && suit.equals(card.suit);
    }
    public boolean equalsRank(Card card){
        return rank == card.rank;
    }
}
