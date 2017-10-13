package com.example.lloc.ecologic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by lLoïc on 21/06/2017.
 */

public class ChoixJeu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choixjeu);
        final Button button=(Button) findViewById(R.id.button25);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChoixJeu.this,Memory.class);
                startActivity(intent);
            }
        });
        Button button1=(Button) findViewById(R.id.button26);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChoixJeu.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
