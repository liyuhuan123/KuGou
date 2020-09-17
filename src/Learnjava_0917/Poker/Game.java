package Learnjava_0917.Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<Player> playerList = initializePlayerList();
        List<Card> cardList = initializeCardList();
        Collections.shuffle(cardList);
        drawCard(playerList,cardList);
        printHands(playerList);
    }
    private static void printHands(List<Player> playerList){
        for(Player player : playerList){
            System.out.printf("%s的手牌：%s%n",player.name,player.cardList);
        }
    }
    private static void drawCard(List<Player> playerList,List<Card> cardList){
        while(true){
            for(Player player : playerList){
                if(cardList.isEmpty()){
                    return;
                }
                Card card = cardList.remove(0);
                boolean temp = true;
                Iterator<Card> it = player.cardList.iterator();
                while(it.hasNext()){
                    Card everyCard = it.next();
                    if(everyCard.equalsRank(card)){
                        it.remove();
                        temp = false;
                    }
                }
                if(temp){
                    player.cardList.add(card);
                }

            }
        }
    }
    private static List<Card> initializeCardList(){
        List<Card> cardList = new ArrayList<>();
        for(String suit : new String[] {"♠","♥","♦","♣"}){
            for(int rank = 1;rank <= 5;rank++){
                cardList.add(new Card(suit,rank));
            }
        }
        cardList.remove(0);
        return cardList;
    }
    private static List<Player> initializePlayerList(){
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("周润发"));
        playerList.add(new Player("刘德华"));
        playerList.add(new Player("高博"));
        playerList.add(new Player("陈培鑫"));
        playerList.add(new Player("许之"));
        return playerList;
    }
}
