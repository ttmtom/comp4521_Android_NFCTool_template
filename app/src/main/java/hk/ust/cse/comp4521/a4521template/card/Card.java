package hk.ust.cse.comp4521.a4521template.card;

import android.media.Image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.comp4521.a4521template.action.Action;

/**
 * Created by TM on 23-Mar-18.
 */

public class Card implements Serializable{
    private String cardName;
    private String cardTag;
    private List<Action> turnOnActions;
    private byte[] cardID;
    private Image cardImage;
    private boolean isActivate;
    private boolean[] actionSetting;

    public Card(){
        turnOnActions = new ArrayList<>();
    }

    public Card(String cardName, String cardTag, byte[] tagID, Image cardImage){
        this.cardName = cardName;
        this.cardTag = cardTag;
        this.cardID = tagID;
        this.cardImage = cardImage;
        turnOnActions = new ArrayList<>();
        isActivate = false;
    }

    public void cardTurnOn(){
        for(Action a :turnOnActions)
            a.turnOn();
        isActivate = true;
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

    public byte[] getCardID(){
        return cardID;
    }

    public boolean isActivate(){
        return isActivate;
    }

    public List<Action> getTurnOnActions(){
        return turnOnActions;
    }


}
