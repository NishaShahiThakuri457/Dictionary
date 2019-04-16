package com.e.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String countries[]=
            {
                    "Nepal","kathmandu",
                    "UK","london",
                    "Brazil","liverpool",
                    "Canada","ottawa",
                    "Spain","barcelona",
                    "Korea","seoul",
                    "USA","washington",
            };

    private Map<String,String> dictinoary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvcountries = findViewById(R.id.lvcountries);

        dictinoary = new HashMap<>();
        for (int i = 0; i < countries.length; i += 2) {
            dictinoary.put(countries[i], countries[i + 1]);

        }

        ArrayAdapter countryAdapter = new ArrayAdapter<>(
                this, //activity
                android.R.layout.simple_list_item_1, //layout
                new ArrayList<String>(dictinoary.keySet())
        );


        lvcountries.setAdapter(countryAdapter);

        lvcountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String country=parent.getItemAtPosition(position).toString();
                String capital=dictinoary.get(country);

                Intent intent=new Intent(MainActivity.this,CapitalActivity.class);

                intent.putExtra("countries",capital);
                startActivity(intent);
        }

    });
    }
}


