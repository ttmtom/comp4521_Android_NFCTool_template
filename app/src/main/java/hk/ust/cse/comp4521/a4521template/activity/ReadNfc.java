package hk.ust.cse.comp4521.a4521template.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import hk.ust.cse.comp4521.a4521template.R;
import hk.ust.cse.comp4521.a4521template.card.Card;
import hk.ust.cse.comp4521.a4521template.card.Manager;

public class ReadNfc extends AppCompatActivity implements View.OnClickListener{

    private NfcAdapter nfcAdapter;
    private PendingIntent mPendingIntent;
    byte[] cardID;

    Intent intent = new Intent(getBaseContext(), CreateCard.class);
    Manager manager = (Manager) intent.getSerializableExtra("manager");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_nfc);

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        mPendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
    }

    @Override
    public void onResume() {
        super.onResume();
        nfcAdapter.enableForegroundDispatch(this, mPendingIntent, null, null);

        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())) {

        }
        else if(NfcAdapter.ACTION_TAG_DISCOVERED.equals(getIntent().getAction())){
            // check the id
            Tag tag = getIntent().getParcelableExtra(NfcAdapter.EXTRA_TAG);
            cardID = tag.getId();
            for(Card c : manager.getCards()) {
                // check the card already added
                if (c.getTagID().equals(cardID)){
                    //TODO show message and do nothing

                    return;
                }
            }

            //new id
            //TODO show button and ID
        }
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onNewIntent(Intent intent) {
        setIntent(intent);
    }

    @Override
    public  void onClick(View v){
        //TODO
        intent.putExtra("cardID", cardID);
        intent.putExtra("manager",manager);
        startActivity(intent);
    }
}
