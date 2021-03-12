import java.util.ArrayList;

enum Suite{
    CLUB(0),
    SPADE(1),
    DIAMOND(2),
    HEART(3);

    int x;
    Suite(int x){this.x=x;}
}

class Card{
    int faceNumber;
    Suite suite;
    Card(int number,Suite suite){
        this.faceNumber=number;
        this.suite=suite;
    }
}


public class Deck {
    ArrayList<Card> cards;
    Deck(){
        this.cards=new ArrayList<>();
        for(int i=1;i<=13;i++){
            for (Suite suite:Suite.values()){
                cards.add(new Card(i,suite));
            }
        }
    }

    public static void main(String[] args) {

    }
}

