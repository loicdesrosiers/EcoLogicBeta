package com.example.lloc.ecologic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by lLoïc on 21/06/2017.
 */

public class Progression extends AppCompatActivity {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progression);
        spinner=(Spinner) findViewById(R.id.spinner);
        adapter =ArrayAdapter.createFromResource(this,R.array.Titres,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
}
