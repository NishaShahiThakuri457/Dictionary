package com.e.dictionary;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CapitalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital);

        TextView tvcapital=findViewById(R.id.tvcapital);
        Bundle bundle=getIntent().getExtras();

        if(bundle!=null){
            String message=bundle.getString("myMessage");
            tvcapital.setText(message);

        }
        else {
            Toast.makeText(this, "no message", Toast.LENGTH_LONG).show();
        }
    }
}
