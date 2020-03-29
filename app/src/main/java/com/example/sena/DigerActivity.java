package com.example.sena;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DigerActivity extends AppCompatActivity {

    Button digertemizlebutton;
    EditText Searchtext;
    private DigerAdapter adapter;
    ImageButton bt_mic;
    private List<DigerItem> digerList;
    private List<DigerItem> examples;

    private Context context;
    SharedPreferences sharedPreferences;
    Intent intent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_diger);
        this.context=getApplicationContext();
        this.intent = getIntent();
        fillDigerList();
        setUpRecyclerView();
        initToolbar();
        this.Searchtext = (EditText) findViewById(R.id.search_input);
        sharedPreferences = context.getSharedPreferences("mypref", MODE_PRIVATE); //
        this.Searchtext.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void afterTextChanged(Editable editable) {
                DigerActivity.this.filterQuery(editable.toString());
            }
        });

        digertemizlebutton=(Button)findViewById(R.id.digerTemizle);  //temizle butonunda geri dönüşte 0 olması için
        digertemizlebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ogun=intent.getStringExtra("ogun");
                String ogunValueName=null;
                if(ogun.equals("diger")){
                    ogunValueName="digerValue";
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt(ogunValueName,0);
                editor.apply();
            }
        });

    }

    private void fillDigerList() {
        this.digerList = new ArrayList();
        this.digerList.add(new DigerItem("Portakal(1 adet) ", "50 kcal",50));
        this.digerList.add(new DigerItem("Greyfurt(1 adet)", "60 kcal",60));
        this.digerList.add(new DigerItem("Armut(1 adet)", "70 kcal",70));
        this.digerList.add(new DigerItem("Elma(1 adet)", "60 kcal",60));
        this.digerList.add(new DigerItem("Çilek(100 gr)", "26 kcal",26));
        this.digerList.add(new DigerItem("İncir(100gr)", "41 kcal",41));
        this.digerList.add(new DigerItem("Karpuz(1 ince dilim)", "40 kcal",40));
        this.digerList.add(new DigerItem("Kivi(1 adet)", "34 kcal",34));
        this.digerList.add(new DigerItem("Mandalina(1 adet)", "50 kcal",50));
        this.digerList.add(new DigerItem("Muz (1 adet) ", "100 kcal",100));
        this.digerList.add(new DigerItem("Şeftali(1 adet) ", "60 kcal",60));
        this.digerList.add(new DigerItem("Üzüm(100 gr) ", "57 kcal",57));
        this.digerList.add(new DigerItem("Kiraz(100 gr) ", "63 kcal",63));
        this.digerList.add(new DigerItem("Ananas(100 gr) ", "56 kcal",56));
        this.digerList.add(new DigerItem("Badem(100 gr) ", "600 kcal",600));
        this.digerList.add(new DigerItem("Ceviz(100 gr) ", "549 kcal",549));
        this.digerList.add(new DigerItem("Çam Fıstığı(100 gr) ", "600 kcal",600));
        this.digerList.add(new DigerItem("Fındık(100 gr) ", "650 kcal",650));
        this.digerList.add(new DigerItem("Fıstık(100 gr) ", "560 kcal",560));
        this.digerList.add(new DigerItem("Tepsi Börek(1 porsiyon 100gr)", "421 kcal",421));
        this.digerList.add(new DigerItem("Kola(100 ml)", "42 kcal",42));
        this.digerList.add(new DigerItem("Zeytinyağlı Fasülye(1 porsiyon 100gr)", "177 kcal",177));
        this.digerList.add(new DigerItem("Kıymalı Biber Dolma(1 porsiyon 100gr)", "226 kcal",226));
        this.digerList.add(new DigerItem("Zeytinyağlı Pırasa(1 porsiyon 100gr)", "225 kcal",225));
        this.digerList.add(new DigerItem("Kıymalı Patates(1 porsiyon 100gr)", "250 kcal",250));
        this.digerList.add(new DigerItem("Kuru Fasulye(1 porsiyon 100gr)", "336 kcal",336));
        this.digerList.add(new DigerItem("Zeytinyağlı Bakla(1 porsiyon 100gr)", "266 kcal",266));
        this.digerList.add(new DigerItem("Kuru Nohut(1 porsiyon 100gr)", "350 kcal",350));
        this.digerList.add(new DigerItem("Limonata(100 ml)", "42 kcal",42));
        this.digerList.add(new DigerItem("Zeytinyağlı Barbunya(1 porsiyon 100gr)", "328 kcal",328));
        this.digerList.add(new DigerItem("Patlıcan Musakka(1 porsiyon 100gr)", "201 kcal",201));
        this.digerList.add(new DigerItem("Kıymalı Ispanak(1 porsiyon 100gr)", "276 kcal",276));
        this.digerList.add(new DigerItem("Kıymalı Bezelye(1 porsiyon 100gr)", "298 kcal",298));
        this.digerList.add(new DigerItem("Kıymalı karnabahar(1 porsiyon 100gr)", "187 kcal",187));
        this.digerList.add(new DigerItem("Kıymalı Kapuska(1 porsiyon 100gr)", "190 kcal",190));
        this.digerList.add(new DigerItem("Pirinç Pilavı(1 porsiyon 100gr)", "326 kcal",326));
        this.digerList.add(new DigerItem("Tas Kebabı(1 porsiyon 100gr)", "343 kcal",343));
        this.digerList.add(new DigerItem("Yaz Türlüsü(1 porsiyon 100gr)", "221 kcal",221));
        this.digerList.add(new DigerItem( "Bulgur Pilavı(1 porsiyon 100gr)", "291 kcal",291));
        this.digerList.add(new DigerItem( "Cacık(1 porsiyon 100gr)", "191 kcal",191));
        this.digerList.add(new DigerItem("Elma Komposto(1 bardak 200 ml)", "193 kcal",193));
        this.digerList.add(new DigerItem("Gazoz(100 ml)", "42 kcal",42));
        this.digerList.add(new DigerItem( "Fırın Makarna(1 porsiyon 100gr)", "505 kcal",505));
        this.digerList.add(new DigerItem("Haşlanmış Tavuk(1 porsiyon 100gr)", "259 kcal",259));
        this.digerList.add(new DigerItem("Havuç Salata(1 porsiyon 100gr)", "144 kcal",144));
        this.digerList.add(new DigerItem("Pizza(1 adet)", "584 kcal",584));
        this.digerList.add(new DigerItem("Balık Tava (1 porsiyon 100gr)", "370 kcal",370));
        this.digerList.add(new DigerItem("Talaş Böreği(1 porsiyon 100gr)", "360 kcal",360));
        this.digerList.add(new DigerItem("Ayran (1 bardak 200ml)", "70 kcal",70));
        this.digerList.add(new DigerItem("Etli pide (1 adet)", "570 kcal",570));
        this.digerList.add(new DigerItem("Midye (1 adet)", "9 kcal",9));
        this.digerList.add(new DigerItem("İstiridye (1 adet)", "6 kcal",6));
        this.digerList.add(new DigerItem("IceTea(100 ml)", "27 kcal",27));
        this.digerList.add(new DigerItem("Karides(1 adet)", "144 kcal",144));
        this.digerList.add(new DigerItem("Somon Füme (100gr)", "171 kcal",171));
        this.digerList.add(new DigerItem("Ton Balığı (100gr)", "121 kcal",121));
        this.digerList.add(new DigerItem("Brokoli (100gr)", "35 kcal",35));
        this.digerList.add(new DigerItem("Kereviz (100gr)", "18 kcal",18));
        this.digerList.add(new DigerItem("Biftek Izgara (1 porsiyon 100gr)", "278 kcal",278));
        this.digerList.add(new DigerItem("Tavuk Izgara (1 porsiyon 100gr)", "132 kcal",132));
        this.digerList.add(new DigerItem("Kuzu Izgara (1 porsiyon 100gr)", "282 kcal",282));
        this.digerList.add(new DigerItem("Nohut (1 porsiyon 100gr)", "364 kcal",364));
        this.digerList.add(new DigerItem("Yeşil Mercimek (1 porsiyon 100gr)", "257 kcal",257));
        this.digerList.add(new DigerItem("Biftek Izgara (1 porsiyon 100gr)", "278 kcal",278));
        this.digerList.add(new DigerItem("Biftek Izgara (1 porsiyon 100gr)", "278 kcal",278));
        this.digerList.add(new DigerItem("İmambayıldı(1 porsiyon 100gr)", "194 kcal",194));
        this.digerList.add(new DigerItem("İzmir Köfte(1 porsiyon 100gr)", "348 kcal",348));
        this.digerList.add(new DigerItem("Kabak Dolma(1 porsiyon 100gr)", "247 kcal",247));
        this.digerList.add(new DigerItem("Rosto Et(1 porsiyon 100gr)", "311 kcal",311));
        this.digerList.add(new DigerItem("Peynirli Makarna(1 porsiyon 100gr)", "354 kcal",354));
        this.digerList.add(new DigerItem("Patlıcan Kebabı(1 porsiyon 100gr)", "406 kcal",406));
        this.digerList.add(new DigerItem("Adana Kebap (1 porsiyon)", "870 kcal",870));
        this.digerList.add(new DigerItem("Al, Nazik (1 porsiyon)", "407 kcal",407));
        this.digerList.add(new DigerItem("Kağıt Kebabı (1 porsiyon)", "139 kcal",139));
        this.digerList.add(new DigerItem("Patlıcan Kebabı(1 porsiyon)", "276 kcal",276));
        this.digerList.add(new DigerItem("İskender(1 porsiyon)", "970 kcal",970));
        this.digerList.add(new DigerItem("Et Şiş(1 adet)", "120 kcal",120));
        this.digerList.add(new DigerItem("Beyti Kebabı(1 porsiyon)", "850 kcal",580));
        this.digerList.add(new DigerItem("Paçanga Böreği(135 gr )", "504 kcal",504));
        this.digerList.add(new DigerItem("İçli Köfte(1 adet)", "150 kcal",150));
        this.digerList.add(new DigerItem("Su Böreği(1 porsiyon)", "450 kcal",450));
        this.digerList.add(new DigerItem("Sigara Böreği(1 porsiyon)", "85 kcal",85));
        this.digerList.add(new DigerItem("Bezelye(1 porsiyon 100gr)", "289 kcal",289));
        this.digerList.add(new DigerItem("Sulu Köfte(1 porsiyon 100gr)", "256 kcal",256));
        this.digerList.add(new DigerItem("Mantı(1 porsiyon 100gr)", "341 kcal",341));
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById( R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        this.adapter = new DigerAdapter(this.digerList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(this.adapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) { //girilen verilerin toplanması,toplam kcal hesabı
                        String ogun=intent.getStringExtra("ogun");
                        String ogunValueName=null;
                        if(ogun.equals("diger")){
                            ogunValueName="digerValue";
                        }
                        int ogunTotal=sharedPreferences.getInt(ogunValueName,0);
                        System.out.println("toplam:"+ogunTotal);
                        int currentCalValue=digerList.get(position).getCalValue();
                        System.out.println("current:"+currentCalValue); //gereksiz
                        ogunTotal+=currentCalValue;
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putInt(ogunValueName,ogunTotal);
                        editor.apply();
                        Toast.makeText(getApplicationContext(), digerList.get(position).getText2()+" eklendi.", Toast.LENGTH_LONG).show();
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        System.out.println("uzun tıklandı");  //gereksiz.
                    }
                })
        );

    }

    private void initToolbar() {   //toolbar içeriği
        setSupportActionBar((Toolbar) findViewById( R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Diğer Öğün");
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);



    }


    public void filterQuery(String text) {  //filtreleme
        ArrayList<DigerItem> filterdNames = new ArrayList<>();
        for (DigerItem s : this.digerList) {
            if (s.getText1().toLowerCase().contains(text) || s.getText2().toLowerCase().contains(text)) {
                filterdNames.add(s);
            }
        }
        this.adapter.setFilter(filterdNames);
    }

}
