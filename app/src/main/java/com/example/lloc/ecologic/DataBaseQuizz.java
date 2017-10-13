package com.example.lloc.ecologic;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lLoïc on 10/09/2017.
 */

public class DataBaseQuizz extends SQLiteOpenHelper {

    public static final String TABLE_NAME="Quizz";
    Context context;

    public DataBaseQuizz(Context context){
        super(context,TABLE_NAME, null,1);
        this.context=context;
    }

    public int getRowCount(){
       /* Cursor data = this.getData();
        int borne=0;
        while( data.moveToNext()){
            borne+=1;
        }
*/
        return 3;
    }
    public Cursor getData(){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor c = database.rawQuery("Select * from Quizz",null);
        return c;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String creertable=" Create table "+TABLE_NAME+" (  IDquestion integer primary key autoincrement, intitule varchar2(500) unique , reponse1 varchar2(20), reponse2 varchar2(20),reponse3 varchar2(20),reponse4 varchar2(20), bonnereponse varchar2(20), score number )";
        db.execSQL(creertable);
        ajouter();

        }

        public StringBuffer showAllData(){
            Cursor data= this.getData();
            StringBuffer stringBuffer=new StringBuffer();
            while( data.moveToNext()){
                stringBuffer.append("Prenom: "+data.getString(0)+"\n");
                stringBuffer.append("Nom: "+data.getString(1)+"\n");
                stringBuffer.append("Mot de passe: "+data.getString(2)+"\n\n");

            }
            return stringBuffer;
        }
    public boolean ajouter(){
       SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
     /*   contentValues.put("intitule","Qu'est ce qui est jaune et qui attend ?");
        contentValues.put("reponse1","Johnatan");
        contentValues.put("reponse2","Quoi?");
        contentValues.put("reponse3","La mer noire");
        contentValues.put("reponse4","Aucune idée");
        contentValues.put("bonnereponse","Johnatan");
        contentValues.put("score","50");


*/

        contentValues.put("intitule","Qui n'est pas dans le groupe de ptut?");
        contentValues.put("reponse1","Corentin");
        contentValues.put("reponse2","Alexis?");
        contentValues.put("reponse3","Sangoku");
        contentValues.put("reponse4","Nathan");
        contentValues.put("bonnereponse","Sangoku");
        contentValues.put("score","50");

        long result = db.insert(TABLE_NAME,null,contentValues);
       /*
        contentValues.put("intitule","?");
        contentValues.put("reponse1","Corentin");
        contentValues.put("reponse2","Alexis?");
        contentValues.put("reponse3","Sangoku");
        contentValues.put("reponse4","Nathan");
        contentValues.put("bonnereponse","Sangoku");
        contentValues.put("score","50");
        db.insert(TABLE_NAME,null,contentValues);
        */


// Si la donnée s'est mal insérée, result sera a -1 sinon 0
        if (result==-1)return false;
        else return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}

