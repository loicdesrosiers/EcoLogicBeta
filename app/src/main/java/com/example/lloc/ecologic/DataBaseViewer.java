package com.example.lloc.ecologic;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import java.lang.*;

/**
 * Created by lLoïc on 10/09/2017.
 */

public class DataBaseViewer extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate( Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.list_layout);
        db=new DatabaseHelper(this);

        populateListView();
    }
    private void populateListView() {
       Cursor data= db.getData();
        StringBuffer stringBuffer=new StringBuffer();
        while( data.moveToNext()){
            stringBuffer.append("Prenom: "+data.getString(0)+"\n");
            stringBuffer.append("Nom: "+data.getString(1)+"\n");
            stringBuffer.append("Mot de passe: "+data.getString(2)+"\n\n");

        }
        showMessage(stringBuffer.toString());


    }
    private void showMessage(String message){

        AlertDialog.Builder dialog =new AlertDialog.Builder(this);
        dialog.setCancelable(true);
        dialog.setTitle("Données");
        dialog.setMessage(message);
        dialog.show();

    }
}
