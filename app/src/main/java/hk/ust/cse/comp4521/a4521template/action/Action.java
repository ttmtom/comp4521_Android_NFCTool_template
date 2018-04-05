package hk.ust.cse.comp4521.a4521template.action;

import android.app.Activity;

/**
 * Created by TM on 23-Mar-18.
 */

public abstract class Action extends Activity{
    private boolean startSetting;
    public abstract void turnOn();
    public abstract void turnOff();

    public Action(boolean startSetting){
       this.startSetting = startSetting;
    }
}
