package com.example.lloc.ecologic;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.view.menu.ExpandedMenuView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Handler;

/**
 * Created by lLoïc on 21/06/2017.
 */

public class Memory extends AppCompatActivity {

   ArrayList<Button> tabBouttons=new ArrayList();

    static int carte1=-1;
    static int carte2=-1;
    ArrayList<String> chaines=new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory);
        chaines.add("Poubelle jaune");
        chaines.add("Poubelle jaune");
        chaines.add("Poubelle verte");
        chaines.add("Poubelle verte");
        chaines.add("Poubelle marron");
        chaines.add("Poubelle marron");
        chaines.add("Poubelle bleue");
        chaines.add("Poubelle bleue");
        chaines.add("Poubelle rouge");
        chaines.add("Poubelle rouge");
        chaines.add("Poubelle noire");
        chaines.add("Poubelle noire");




        final Button button=(Button) findViewById(R.id.button24);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Memory.this, MenuPrincipal.class);

                startActivity(intent);
                finish();

            }
        });
        final Button button1=(Button) findViewById(R.id.button13);
        final Button button2=(Button) findViewById(R.id.button14);
        final Button button3=(Button) findViewById(R.id.button12);
        final Button button4=(Button) findViewById(R.id.button15);
        final Button button5=(Button) findViewById(R.id.button16);
        final Button button6=(Button) findViewById(R.id.button17);
        final Button button7=(Button) findViewById(R.id.button18);
        final Button button8=(Button) findViewById(R.id.button19);
        final Button button9=(Button) findViewById(R.id.button20);
        final Button button10=(Button) findViewById(R.id.button21);
        final Button button11=(Button) findViewById(R.id.button22);
        final Button button12=(Button) findViewById(R.id.button23);

        tabBouttons.add(button1);
        tabBouttons.add(button2);
        tabBouttons.add(button3);
        tabBouttons.add(button4);
        tabBouttons.add(button5);
        tabBouttons.add(button6);
        tabBouttons.add(button7);
        tabBouttons.add(button8);
        tabBouttons.add(button9);
        tabBouttons.add(button10);
        tabBouttons.add(button11);
        tabBouttons.add(button12);

        for(final Button b:tabBouttons){
            b.setTextSize(0);
            Random rnd =new Random();
            int i=rnd.nextInt(chaines.size());
            b.setText(chaines.get(i));
            chaines.remove(i);


            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(Memory.this,b.getText(),Toast.LENGTH_SHORT).show();
                    b.setBackgroundResource(R.drawable.buttonshape);

                    if(carte1==-1) carte1=tabBouttons.indexOf(b);
                    else{
                        if (carte2==-1) carte2=tabBouttons.indexOf(b);
                    }
                    if(carte1!=-1 && carte2!=-1 ){
                        if(carte1 != carte2 && tabBouttons.get(carte1).getText().equals(tabBouttons.get(carte2).getText())) {

                            tabBouttons.get(carte1).setVisibility(View.INVISIBLE);
                            tabBouttons.get(carte2).setVisibility(View.INVISIBLE);
                            carte1 = -1;
                            carte2 = -1;
                        }else {

                            tabBouttons.get(carte1).setBackgroundResource(R.drawable.cartedos);
                            tabBouttons.get(carte2).setBackgroundResource(R.drawable.cartedos);
                            carte1=-1;
                            carte2=-1;
                        }
                    }
                }
            });
        }


    }





    }

