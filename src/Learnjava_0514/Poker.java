package Learnjava_0514;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card{
    //这是一张牌
    private String rank;//点数
    private String suit;//花色

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "[" +this.suit +this.rank + "]";
    }
}
public class Poker {
    public static void main(String[] args) {
        //1.创建一副牌
        List<Card> poker = buyPoker();
        //2.洗牌,可以直接使用Collections.shuffle方法
        //把List中的元素随机打乱顺序
        Collections.shuffle(poker);
        //3.发牌假设有三个玩家每人发5张牌，每个玩家就是一个List，把多个玩家的信息再放到一个List中
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        //给三个玩家发牌
        for(int i = 0;i < 5;i++){
            for(int j = 0;j < 3;j++){
                List<Card> player = players.get(j);
                player.add(poker.remove(0));//删除指定下标元素remove 返回值表示这个元素是啥
            }
        }
        //发牌结束，查看手牌
        for(int i = 0;i < 3;i++){
            System.out.println("玩家" + i + ":" +players.get(i));
        }
    }
    private static List<Card> buyPoker(){
        List<Card> poker = new ArrayList<>();
        String[] suits = {"♥","♠","♣","♦"};
        for(int i = 0;i < 4;i++){
            //这个循环来处理四种花色
            //每种花色又有十三张牌
            for(int j = 2;j <= 10;j++){
                //j表示点数，int => String
                //"" + j整数转字符串
                //String.valueOf(j)
                poker.add(new Card("" + j,suits[i]));
            }
            poker.add(new Card("J",suits[i]));
            poker.add(new Card("Q",suits[i]));
            poker.add(new Card("K",suits[i]));
            poker.add(new Card("A",suits[i]));
        }
        return poker;
    }
}
