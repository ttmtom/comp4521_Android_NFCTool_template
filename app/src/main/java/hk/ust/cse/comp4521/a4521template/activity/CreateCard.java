package hk.ust.cse.comp4521.a4521template.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import hk.ust.cse.comp4521.a4521template.R;
import hk.ust.cse.comp4521.a4521template.card.Manager;

public class CreateCard extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card);


    }

    @Override
    public void onClick(View v){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            byte[] cardID = extras.getByteArray("cardID");
            Manager manager =(Manager) getIntent().getSerializableExtra("manager");
            // TODO add
            manager.addCard();
        }
    }
}
