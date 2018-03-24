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

public class StartPage extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

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
            new AlertDialog.Builder(this).setTitle("Error").setMessage("Your device not support NFC")
                    .setPositiveButton("Quit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finishAndRemoveTask();
                        }
                    }).show();
        } else if (!nfcAdapter.isEnabled()) {
            new AlertDialog.Builder(this).setTitle("Error").setMessage("NFC is disable, Pls turn on NFC")
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

        //1. show list
        //2. wait for click action



    }

    @Override
    public void onClick(View v){
        // from long click
        manager.removeCard("test");



        // from FloatingActionButton
        // 1. add  new card
        Intent intent = new Intent(getBaseContext(), ReadNfc.class);
        intent.putExtra("manger", manager);
        startActivity(intent);
        //2. import FileChooser

        //3. export Serializable

    }

    @Override
    public boolean onLongClick(View v){
        // show remove, edit button
        return true;
    }

}
