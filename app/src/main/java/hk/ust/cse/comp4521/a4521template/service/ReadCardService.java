package hk.ust.cse.comp4521.a4521template.service;

import android.app.IntentService;
import android.content.Intent;

import hk.ust.cse.comp4521.a4521template.activity.StartPage;
import hk.ust.cse.comp4521.a4521template.card.Manager;

/**
 * Created by TM on 28-Mar-18.
 */

public class ReadCardService extends IntentService {
    private Manager manager;
    public ReadCardService(){
        super("ReadCardService");
        Intent intent = new Intent(getBaseContext(), StartPage.class);
        manager = (Manager) intent.getSerializableExtra("manager");
    }

    @Override
    protected void onHandleIntent(Intent workIntent){

    }
}
