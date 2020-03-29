package com.example.sena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     Button digerbttn;
     Button oglenbttn;
     Button kahvaltibttn;
     Button aksambttn;

    private Context context;
    SharedPreferences sharedPreferences;  // verileri(öğün içeriklerini)tutar.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context=getApplicationContext();


        sharedPreferences = context.getSharedPreferences("mypref", MODE_PRIVATE);

        TextView kahvaltiText = (TextView) findViewById(R.id.kahvaltiText);//KCAL HESAPLANDĞINDA KAHVALTI BUTTONU ALTINDAKİ TEXT KISMI
        kahvaltiText.setText(Integer.toString(sharedPreferences.getInt("kahvaltıValue",0))+" "+"kcal"); //öğünleri gösterir.

        TextView oglenText=(TextView) findViewById(R.id.oglenText);
        oglenText.setText(Integer.toString(sharedPreferences.getInt("oglenValue",0))+" "+"kcal");

        TextView aksamText = (TextView) findViewById(R.id.aksamText);//KCAL HESAPLANDĞINDA KAHVALTI BUTTONU ALTINDAKİ TEXT KISMI
        aksamText.setText(Integer.toString(sharedPreferences.getInt("aksamValue",0))+" "+"kcal"); //öğünleri gösterir.

        TextView digerText = (TextView) findViewById(R.id.digerText);//KCAL HESAPLANDĞINDA KAHVALTI BUTTONU ALTINDAKİ TEXT KISMI
        digerText.setText(Integer.toString(sharedPreferences.getInt("digerValue",0))+" "+"kcal"); //öğünleri gösterir.




        kahvaltibttn=(Button)findViewById(R.id.kahvaltiButton);  //kahvaltı butonuna tıkladığında yiyeceklere geçiş yap.
        kahvaltibttn.setOnClickListener(new View.OnClickListener() {// activity.main den kahvalti ekranına geçiş.
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, KahvaltiActivity.class);
                gecisYap.putExtra("ogun", "kahvaltı");
                startActivity(gecisYap);
    }
});

        oglenbttn=(Button)findViewById(R.id.oglenButton);
        oglenbttn.setOnClickListener(new View.OnClickListener() {// activity.main den kahvalti ekranına geçiş.

            @Override
            public void onClick(View v) {
                Intent gecYap = new Intent(MainActivity.this, OglenActivity.class);
                gecYap.putExtra("ogun", "oglen");
                startActivity(gecYap);
            }
            });



        aksambttn=(Button)findViewById(R.id.aksamButton);
        aksambttn.setOnClickListener(new View.OnClickListener() {// activity.main den kahvalti ekranına geçiş.

            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, AksamActivity.class);
                gecisYap.putExtra("ogun", "aksam");
                startActivity(gecisYap);
            }
        });


        digerbttn=(Button)findViewById(R.id.digerButton);
        digerbttn.setOnClickListener(new View.OnClickListener() {// activity.main den kahvalti ekranına geçiş.

            @Override
            public void onClick(View v) {
                Intent gecYap = new Intent(MainActivity.this, DigerActivity.class);
                gecYap.putExtra("ogun", "diger");
                startActivity(gecYap);
            }
        });

    }

        public void onRestart()
        {   // kalori eklemesinde back yapıldığında veri güncellemesi için.
            super.onRestart();

            sharedPreferences = context.getSharedPreferences("mypref", MODE_PRIVATE);

            TextView kahvaltiText = (TextView) findViewById(R.id.kahvaltiText); //KAHVALTI
            kahvaltiText.setText(Integer.toString(sharedPreferences.getInt("kahvaltıValue", 0)) + " "+"kcal");

            TextView oglenText = (TextView) findViewById(R.id.oglenText);  //ÖĞLEN
            oglenText.setText(Integer.toString(sharedPreferences.getInt("oglenValue", 0)) + " "+"kcal");

            TextView aksamText = (TextView) findViewById(R.id.aksamText);  //AKŞAM
            aksamText.setText(Integer.toString(sharedPreferences.getInt("aksamValue", 0)) + " "+"kcal");

            TextView digerText = (TextView) findViewById(R.id.digerText);  //DİĞER
            digerText.setText(Integer.toString(sharedPreferences.getInt("digerValue", 0)) + " "+"kcal");

        }
        }