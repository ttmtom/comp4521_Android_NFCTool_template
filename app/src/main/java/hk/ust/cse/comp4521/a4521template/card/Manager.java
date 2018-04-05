package hk.ust.cse.comp4521.a4521template.card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TM on 23-Mar-18.
 */

public class Manager implements Serializable {
    private List<Card> cards;
    private boolean anyModeOn;

    public Manager(){

        cards = new ArrayList<>();
        anyModeOn = false;
    }

    public void addCard(Card temp){
        //TODO
        cards.add(temp);
    }

    public boolean removeCard(String name){
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getCardName().equals(name)) {
                cards.remove(i);
                return true;
            }
        }
        return false;
    }

    public void restore(){

    }

    public void export(){

    }

    public void importData(){

    }

    public boolean runACard(String name){
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getCardName().equals(name)) {
                cards.get(i).cardTurnOn();
                anyModeOn = true;
                return true;
            }
        }
        return false;
    }

    public void turnOffCard(){
        for(Card c: cards){
            if(c.isActivate()){

            }
        }
    }
/*
    public void turnOff(){
        for(Card c: cards)
            if(c.isActivate()) {
                c.cardOff();
                anyModeOn = false;
                return;
            }
    }
    */

    public boolean isAnyModeOn(){
        return anyModeOn;
    }

    public int getCardsSize(){
        return cards.size();
    }

    public  List<Card> getCards(){
        return cards;
    }
}
