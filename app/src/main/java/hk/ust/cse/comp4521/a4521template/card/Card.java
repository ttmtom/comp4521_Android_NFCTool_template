package hk.ust.cse.comp4521.a4521template.card;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.comp4521.a4521template.action.Action;

/**
 * Created by TM on 23-Mar-18.
 */

public class Card {
    private String cardName;
    private String cardTag;
    private List<Action> turnOnActions;
    private List<Action> turnOffActions;
    private byte[] tagID;
    private Image cardImage;

    public Card(){
        turnOnActions = new ArrayList<Action>();
        turnOffActions = new ArrayList<Action>();

    }

    public Card(String cardName, String cardTag, byte[] tagID, Image cardImage){
        this.cardName = cardName;
        this.cardTag = cardTag;
        this.tagID = tagID;
        this.cardImage = cardImage;
        turnOnActions = new ArrayList<Action>();
        turnOffActions = new ArrayList<Action>();
    }

    public void addTurnOnActions(){
        //TODO
        //turnOnActions.add();
    }


    public void addTurnOffActions(){
        //TODO
        //turnOffActions.add();
    }


    public void setCardName(String cardName){
        this.cardName = cardName;
    }

    public void setCardTag(String cardTag){
        this.cardTag = cardTag;
    }

    public String getCardName(){
        return cardName;
    }

    public String getCardTag(){
        return cardTag;
    }

    public byte[] getTagID(){
        return tagID;
    }

    public List<Action> getTurnOnActions(){
        return turnOnActions;
    }

    public List<Action> getTurnOffActions(){
        return turnOffActions;
    }

}
