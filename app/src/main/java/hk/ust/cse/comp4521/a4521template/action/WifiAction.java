package hk.ust.cse.comp4521.a4521template.action;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;

/**
 * Created by TM on 23-Mar-18.
 */

public class WifiAction extends Action{
    public WifiAction(boolean startSetting){
        super(startSetting);
    }

    @Override
    public void turnOn(){
        WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);
    }

    @Override
    public void turnOff(){
        WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(false);
    }
}
