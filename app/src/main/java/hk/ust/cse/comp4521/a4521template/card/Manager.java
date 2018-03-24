package hk.ust.cse.comp4521.a4521template.card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TM on 23-Mar-18.
 */

public class Manager implements Serializable {
    private List<Card> cards;

    public Manager(){
        cards = new ArrayList<Card>();
    }

    public void addCard(){
        //TODO
        cards.add(new Card());
    }

    public void removeCard(String name){
        //TODO

    }

    public int getCardsNum(){
        return cards.size();
    }

    public  List<Card> getCards(){
        return cards;
    }
}
