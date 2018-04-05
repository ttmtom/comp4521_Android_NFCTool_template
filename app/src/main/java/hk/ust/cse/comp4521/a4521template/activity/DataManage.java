package hk.ust.cse.comp4521.a4521template.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import hk.ust.cse.comp4521.a4521template.R;
import hk.ust.cse.comp4521.a4521template.card.Manager;

public class DataManage extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_manager);
        /**
         *      2button
         *      import
         *      export
         */
    }

    @Override
    public void onClick(View v){
        //TODO
        Intent intent = new Intent(getBaseContext(), StartPage.class);
        Manager manager = (Manager) intent.getSerializableExtra("manager");
        manager.importData();
        manager.export();
    }

}
