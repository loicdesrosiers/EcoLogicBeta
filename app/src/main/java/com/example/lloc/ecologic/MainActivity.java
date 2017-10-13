package com.example.lloc.ecologic;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button) findViewById(R.id.button);
        Button button2= (Button) findViewById(R.id.button2);
        Button button3= (Button) findViewById(R.id.button3);
        Button button4= (Button) findViewById(R.id.button4);
        TextView textView= (TextView) findViewById(R.id.textView);
        DataBaseQuizz dataBaseQuizz=new DataBaseQuizz(this);

       StringBuffer donnees= dataBaseQuizz.showAllData();
        showMessage(donnees.toString());




    }
    private void showMessage(String message){

        AlertDialog.Builder dialog =new AlertDialog.Builder(this);
        dialog.setCancelable(true);
        dialog.setTitle("Données");
        dialog.setMessage(message);
        dialog.show();

    }
}
