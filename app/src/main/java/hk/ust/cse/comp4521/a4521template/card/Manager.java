package hk.ust.cse.comp4521.a4521template.card;

import android.content.Intent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TM on 23-Mar-18.
 */

public class Manager implements Serializable {
    private ArrayList<Card> cards;
    boolean anyModeOn;

    public Manager(){

        cards = new ArrayList<>();
        anyModeOn = false;
    }

    public void addCard(Card temp){
        //TODO
        cards.add(temp);
    }

    public void removeCard(String name){
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getCardName().equals(name)) {
                cards.remove(i);
                return;
            }
        }
    }

    public void restore(){

    }

    public void export(){

    }

    public void importData(){

    }

    public void runCard(String name){
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getCardName().equals(name)) {
                cards.get(i).cardOn();
                anyModeOn = true;
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


    public int getCardsSize(){
        return cards.size();
    }

    public  ArrayList<Card> getCards(){
        return cards;
    }
}
