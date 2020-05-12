package Learnjava_0512;

import java.util.Comparator;

class Card implements Comparable<Card>{
    public String rank;//点色
    public String suit;//花色

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card o) {
        //如果认为this比o小,返回<0
        //如果认为=提示比o大,返回>0
        //如果认为this和o相等,返回0
        if(o == null){
            //一般我们认为null的值比较小
            return 1;
        }
        //点数的取值：2~10，J，Q，K，A
        int rank1 = this.getValue();
        int rank2 = o.getValue();
        return rank1 - rank2;
    }
    public int getValue(){
        //把String类型的rank变为数字点数
        int value = 0;
        if("J".equals(rank)){
            value = 11;
        }else if("Q".equals(rank)){
            value = 12;
        }else if("k".equals(rank)){
            value = 13;
        }else if("A".equals(rank)){
            value = 14;
        }else{
            value = Integer.parseInt(rank);//String转为int类型
        }
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        //按照值比较来比较this和obj
        //1.自己和自己比较的情况
        if(this == obj){
            return true;
        }
        //2.obj为null的情况，结果为false
        if(obj == null){
            return false;
        }
        //3.obj这个类型是不是当前Card类型
        if(!(obj instanceof Card)){
            return false;
        }
        //4.真正的比较内容
        Card other = (Card)obj;
        return this.rank.equals(other.rank) &&
                this.suit.equals(other.suit);
    }
}
class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if(o1 == o2){
            return 0;
        }
        if(o1 == null){
            return -1;
        }
        if(o2 == null){
            return 1;
        }
        int value1 = o1.getValue();
        int value2 = o2.getValue();
        return value1 - value2;
    }
}
public class Compare {
    public static void main(String[] args) {
        Card p = new Card("3", "♠");
        Card q = new Card("3", "♥");
        Card o = p;
//        System.out.println(p == o);//true
//        System.out.println(p == q);//false
//        System.out.println(p.equals(o));//true
//        System.out.println(p.equals(q));//false,重写equals方法后为true
//
//        System.out.println(p.compareTo(q));//0
//        System.out.println(p.compareTo(o));//0
        CardComparator comparator = new CardComparator();
        System.out.println(comparator.compare(p,q));//负数
    }
}
