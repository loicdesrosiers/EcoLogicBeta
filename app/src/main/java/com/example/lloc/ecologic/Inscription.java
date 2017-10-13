package com.example.lloc.ecologic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lLoïc on 20/06/2017.
 */

public class Inscription extends AppCompatActivity {
    DatabaseHelper db;
    String nom,Pseudo,mail,motpasse;
    private static final String REGISTER_URL="http://ecologic-lyon1.fr/test/Ajout_bd.php";
    @Override
    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);

        db=new DatabaseHelper(this);
        Button button=(Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name=  (EditText) findViewById(R.id.editText5);
                String user_name=name.getText().toString();

                EditText mot_de_passe=  (EditText) findViewById(R.id.editText);
                String mdp=mot_de_passe.getText().toString();

                EditText mot_de_passe2= (EditText) findViewById(R.id.editText4);
                String mdp2= mot_de_passe2.getText().toString();

                EditText pseudo=  (EditText) findViewById(R.id.editText3);
                String user_pseudo=pseudo.getText().toString();

                EditText mail=  (EditText) findViewById(R.id.editText2);
                String user_mail=mail.getText().toString();

                if(user_name.length()!=0 && mdp.length() !=0 && user_pseudo.length()!=0 && user_mail.length() != 0 && mdp2.equals(mdp)){
                    AjouterDonnees(user_name,mdp,user_pseudo,user_mail);
                    register(user_name,user_mail,mdp,user_pseudo);

                }
                else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(Inscription.this);
                    alert.setTitle("Erreur");
                    alert.setMessage("Vérifiez que les champs soient remplis et les mots de passe identiques");
                    alert.setPositiveButton("OK", null);
                    alert.show();

                }
            }
        });

    }
    private void register(String name, String email, String password, String pseudo) {
        nom=name;
        mail=email;
        motpasse=password;
        Pseudo=pseudo;
        String urlsuffix="?username="+name+"&password="+password+"&email="+email+"&pseudo="+pseudo;
        class RegisterUser extends AsyncTask<String,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading=ProgressDialog.show(Inscription.this,"Patientez...",null,true,true);
            }


            @Override
            protected String doInBackground(String... params) {
                String s =params[0];

                BufferedReader bufferReader=null;
                try{

                    URL url = new URL(REGISTER_URL+s);
                    HttpURLConnection con =(HttpURLConnection) url.openConnection();
                    bufferReader= new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result=bufferReader.readLine();

                    return result;

                }catch (Exception e ){
                    Toast.makeText(getApplicationContext(),"Erreur ",Toast.LENGTH_SHORT).show();
                    return null;
                }
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                if(s.equals("Success"))AjouterDonnees(nom, motpasse, Pseudo,mail);
                loading.dismiss();
            }
        }
        RegisterUser ur =new RegisterUser();
        ur.execute(urlsuffix);
    }
    public void AjouterDonnees(String nom, String mdp, String pseudo,String mail){
       db.ajout(nom,pseudo,mdp,mail);




    }
}
