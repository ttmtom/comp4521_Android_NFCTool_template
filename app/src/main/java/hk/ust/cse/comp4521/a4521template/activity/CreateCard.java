package hk.ust.cse.comp4521.a4521template.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import hk.ust.cse.comp4521.a4521template.R;
import hk.ust.cse.comp4521.a4521template.card.Card;
import hk.ust.cse.comp4521.a4521template.card.Manager;

public class CreateCard extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card);
        //TODO  1. camera photo 2. name text input 3. tag text input 4. ActionList List view 5. create button

        //4. ActionList List :
    }

    @Override
    public void onClick(View v){
        //TODO when user click on create
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //Read ID
            byte[] cardID = extras.getByteArray("cardID");
            Manager manager =(Manager) getIntent().getSerializableExtra("manager");
            // TODO
            Card temp = new Card();
            manager.addCard(temp);
        }
    }
}
