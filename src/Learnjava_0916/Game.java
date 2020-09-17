package Learnjava_0916;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("周润发"));
        playerList.add(new Player("李德华"));
        playerList.add(new Player("高博"));
        playerList.add(new Player("陈培鑫"));
        playerList.add(new Player("许之琛"));
        List<Card> cardList = new ArrayList<>();
        initializeCards(cardList);
        Collections.shuffle(cardList);
        System.out.println("抽牌前");
        int n = 2;
        for(int i = 0;i < n;i++) {
            for (Player player : playerList) {
                Card card = cardList.remove(0);
                player.cardList.add(card);
            }
        }
        System.out.println("现在牌组中剩余的牌");
        System.out.println(cardList);
        for(Player player : playerList){
            System.out.printf("玩家[%s]的手牌是：%s%n" ,player.name,player.cardList);
        }
    }
    private static void initializeCards(List<Card> cardList){
        for(String suit : new String[]{"♠","♥","♦","♣"}){
            for(int rank = 1;rank <= 5;rank++){
                Card card = new Card(suit,rank);
                cardList.add(card);
            }
        }
    }

}
