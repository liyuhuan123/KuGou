package Learnjava_0504;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDemo {
    public static final String[] suits = {"♠","♥","♣","♦"};
    //买一副牌
    private static List<Card> buyDeck(){
        List<Card> deck = new ArrayList<>(52);
        for(int i = 0;i < 4;i++){
            for(int j = 0;j <= 13;j++){
                String suit = suits[i];
                int rank = j;
                Card card = new Card();
                card.rank = rank;
                card.suit = suit;
                deck.add(card);
            }
        }
        return deck;
    }
    private static void swap(List<Card> deck,int i,int j){
        Card t = deck.get(i);
        deck.set(i,deck.get(j));
        deck.set(j,t);
    }
    private static void shuffle(List<Card> deck){
        Random random = new Random(20190505);
        for(int i = deck.size() - 1;i > 0;i--){
            int r = random.nextInt(i);
            swap(deck,i,r);
        }
    }
    public static void main(String[] args){
        List<Card> deck = buyDeck();
        System.out.println("刚买回来的牌：");
        System.out.println(deck);
        shuffle(deck);
        System.out.println("洗过的牌");
        System.out.println(deck);
        //三个人，每个人轮流抓5张牌
        List<List<Card>> hands = new ArrayList<>();
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        for(int i = 0;i < 5;i++){
            for(int j = 0;j < 3;i++){
                hands.get(j).add(deck.remove(0));
            }
        }
        System.out.println("剩余的牌");
        System.out.println("deck");
        System.out.println("A 书中的牌");
        System.out.println(hands.get(0));
        System.out.println("B 手中的牌");
        System.out.println(hands.get(1));
        System.out.println("C 手中的牌");
        System.out.println(hands.get(2));

    }
}
