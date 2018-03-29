package hk.ust.cse.comp4521.a4521template.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.Serializable;

import hk.ust.cse.comp4521.a4521template.R;
import hk.ust.cse.comp4521.a4521template.card.Manager;
import hk.ust.cse.comp4521.a4521template.service.ReadCardService;

public class StartPage extends AppCompatActivity implements View.OnClickListener{

    private NfcAdapter nfcAdapter;
    private Manager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO  add new card, import, export button


            }
        });

        // check Nfc
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (nfcAdapter == null) {
            new AlertDialog.Builder(this).setTitle("Error").setMessage("This device does not support AR NFC.")
                    .setPositiveButton("Quit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finishAndRemoveTask();
                        }
                    }).show();
        } else if (!nfcAdapter.isEnabled()) {
            new AlertDialog.Builder(this).setTitle("Error").setMessage("NFC is disable, Pls turn on.")
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finishAndRemoveTask();
                        }
                    })
                    .setPositiveButton("Go to Setting", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                                startActivity(new Intent(Settings.ACTION_NFC_SETTINGS));
                            else
                                startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                        }
                    }).show();
        }

        //TODO  main page
        manager = new Manager();
        //1. load past data
        manager.restore();

        //2. show list
        //3. wait for click action


        Intent readCardIntent = new Intent(this, ReadCardService.class);
        readCardIntent.putExtra("manager", manager);
        startService(readCardIntent);

    }

    @Override
    public void onClick(View v){
        /**TODO add if condition
                * 1. click on list view show button : remove , edit card name, edit card tag
                */
        //2. remove
        new AlertDialog.Builder(this).setTitle("Remove card").setMessage("Warming: you are going to remove a card.")
                .setPositiveButton("Quit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // TODO get list name
                        manager.removeCard("temp");
                    }
                }).show();
/**
*        TODO pop-up input dialog (edit card name and card tag)
*       https://developer.android.com/guide/topics/ui/dialogs.html
*       Creating a Custom Layout: one  text input, cancel and ok button and call manager.setName(String) and manager.setTag(String)
*/
        // from FloatingActionButton
        // 1. add new card
        Intent intent = new Intent(getBaseContext(), ReadNfc.class);
        intent.putExtra("manger", manager);
        startActivity(intent);

        //2. import
        manager.importData();

        //3. export
        manager.export();

    }


}
