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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OglenActivity extends AppCompatActivity {

    Button oglentemizlebutton;
    EditText Searchtext;
    private OglenAdapter adapter;
    ImageButton bt_mic;
    private List<OglenItem> oglenList;
    private List<OglenItem> examples;

    private Context context;
    SharedPreferences sharedPreferences;
    Intent intent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_oglen);
        this.context=getApplicationContext();
        this.intent = getIntent();
        fillOglenList();
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
                OglenActivity.this.filterQuery(editable.toString());
            }
        });

        oglentemizlebutton=(Button)findViewById(R.id.oglenTemizle);  //temizle butonunda geri dönüşte 0 olması için
        oglentemizlebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ogun=intent.getStringExtra("ogun");
                String ogunValueName=null;
                if(ogun.equals("oglen")){
                    ogunValueName="oglenValue";
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt(ogunValueName,0);
                editor.apply();
            }
        });

    }

    private void fillOglenList() {

        this.oglenList = new ArrayList();
        this.oglenList.add(new OglenItem( "Bulgur Pilavı(1 porsiyon 100gr)", "291 kcal",291));
        this.oglenList.add(new OglenItem( "Cacık(1 porsiyon 100gr)", "191 kcal",191));
        this.oglenList.add(new OglenItem("Elma Komposto(1 bardak 200 ml)", "193 kcal",193));
        this.oglenList.add(new OglenItem("Gazoz(100 ml)", "42 kcal",42));
        this.oglenList.add(new OglenItem( "Fırın Makarna(1 porsiyon 100gr)", "505 kcal",505));
        this.oglenList.add(new OglenItem("Haşlanmış Tavuk(1 porsiyon 100gr)", "259 kcal",259));
        this.oglenList.add(new OglenItem("Havuç Salata(1 porsiyon 100gr)", "144 kcal",144));
        this.oglenList.add(new OglenItem("İmambayıldı(1 porsiyon 100gr)", "194 kcal",194));
        this.oglenList.add(new OglenItem("İzmir Köfte(1 porsiyon 100gr)", "348 kcal",348));
        this.oglenList.add(new OglenItem("Kabak Dolma(1 porsiyon 100gr)", "247 kcal",247));
        this.oglenList.add(new OglenItem("Rosto Et(1 porsiyon 100gr)", "311 kcal",311));
        this.oglenList.add(new OglenItem("Peynirli Makarna(1 porsiyon 100gr)", "354 kcal",354));
        this.oglenList.add(new OglenItem("Patlıcan Kebabı(1 porsiyon 100gr)", "406 kcal",406));
        this.oglenList.add(new OglenItem("Tepsi Börek(1 porsiyon 100gr)", "421 kcal",421));
        this.oglenList.add(new OglenItem("Kola(100 ml)", "42 kcal",42));
        this.oglenList.add(new OglenItem("Zeytinyağlı Fasülye(1 porsiyon 100gr)", "177 kcal",177));
        this.oglenList.add(new OglenItem("Kıymalı Biber Dolma(1 porsiyon 100gr)", "226 kcal",226));
        this.oglenList.add(new OglenItem("Zeytinyağlı Pırasa(1 porsiyon 100gr)", "225 kcal",225));
        this.oglenList.add(new OglenItem("Kıymalı Patates(1 porsiyon 100gr)", "250 kcal",250));
        this.oglenList.add(new OglenItem("Kuru Fasulye(1 porsiyon 100gr)", "336 kcal",336));
        this.oglenList.add(new OglenItem("Zeytinyağlı Bakla(1 porsiyon 100gr)", "266 kcal",266));
        this.oglenList.add(new OglenItem("Kuru Nohut(1 porsiyon 100gr)", "350 kcal",350));
        this.oglenList.add(new OglenItem("Limonata(100 ml)", "42 kcal",42));
        this.oglenList.add(new OglenItem("Zeytinyağlı Barbunya(1 porsiyon 100gr)", "328 kcal",328));
        this.oglenList.add(new OglenItem("Patlıcan Musakka(1 porsiyon 100gr)", "201 kcal",201));
        this.oglenList.add(new OglenItem("Kıymalı Ispanak(1 porsiyon 100gr)", "276 kcal",276));
        this.oglenList.add(new OglenItem("Kıymalı Bezelye(1 porsiyon 100gr)", "298 kcal",298));
        this.oglenList.add(new OglenItem("Kıymalı karnabahar(1 porsiyon 100gr)", "187 kcal",187));
        this.oglenList.add(new OglenItem("Kıymalı Kapuska(1 porsiyon 100gr)", "190 kcal",190));
        this.oglenList.add(new OglenItem("Pirinç Pilavı(1 porsiyon 100gr)", "326 kcal",326));
        this.oglenList.add(new OglenItem("Tas Kebabı(1 porsiyon 100gr)", "343 kcal",343));
        this.oglenList.add(new OglenItem("Yaz Türlüsü(1 porsiyon 100gr)", "221 kcal",221));
        this.oglenList.add(new OglenItem("Bezelye(1 porsiyon 100gr)", "289 kcal",289));
        this.oglenList.add(new OglenItem("Sulu Köfte(1 porsiyon 100gr)", "256 kcal",256));
        this.oglenList.add(new OglenItem("Mantı(1 porsiyon 100gr)", "341 kcal",341));
        this.oglenList.add(new OglenItem("Pizza(1 adet)", "584 kcal",584));
        this.oglenList.add(new OglenItem("Balık Tava (1 porsiyon 100gr)", "370 kcal",370));
        this.oglenList.add(new OglenItem("Talaş Böreği(1 porsiyon 100gr)", "360 kcal",360));
        this.oglenList.add(new OglenItem("Ayran (1 bardak 200ml)", "70 kcal",70));
        this.oglenList.add(new OglenItem("Etli pide (1 adet)", "570 kcal",570));
        this.oglenList.add(new OglenItem("Midye (1 adet)", "9 kcal",9));
        this.oglenList.add(new OglenItem("İstiridye (1 adet)", "6 kcal",6));
        this.oglenList.add(new OglenItem("IceTea(100 ml)", "27 kcal",27));
        this.oglenList.add(new OglenItem("Karides(1 adet)", "144 kcal",144));
        this.oglenList.add(new OglenItem("Somon Füme (100gr)", "171 kcal",171));
        this.oglenList.add(new OglenItem("Ton Balığı (100gr)", "121 kcal",121));
        this.oglenList.add(new OglenItem("Brokoli (100gr)", "35 kcal",35));
        this.oglenList.add(new OglenItem("Kereviz (100gr)", "18 kcal",18));
        this.oglenList.add(new OglenItem("Biftek Izgara (1 porsiyon 100gr)", "278 kcal",278));
        this.oglenList.add(new OglenItem("Tavuk Izgara (1 porsiyon 100gr)", "132 kcal",132));
        this.oglenList.add(new OglenItem("Kuzu Izgara (1 porsiyon 100gr)", "282 kcal",282));
        this.oglenList.add(new OglenItem("Nohut (1 porsiyon 100gr)", "364 kcal",364));
        this.oglenList.add(new OglenItem("Yeşil Mercimek (1 porsiyon 100gr)", "257 kcal",257));
        this.oglenList.add(new OglenItem("Biftek Izgara (1 porsiyon 100gr)", "278 kcal",278));
        this.oglenList.add(new OglenItem("Biftek Izgara (1 porsiyon 100gr)", "278 kcal",278));

        this.oglenList.add(new OglenItem("Adana Kebap (1 porsiyon)", "870 kcal",870));
        this.oglenList.add(new OglenItem("Al, Nazik (1 porsiyon)", "407 kcal",407));
        this.oglenList.add(new OglenItem("Kağıt Kebabı (1 porsiyon)", "139 kcal",139));
        this.oglenList.add(new OglenItem("Patlıcan Kebabı(1 porsiyon)", "276 kcal",276));
        this.oglenList.add(new OglenItem("İskender(1 porsiyon)", "970 kcal",970));
        this.oglenList.add(new OglenItem("Et Şiş(1 adet)", "120 kcal",120));
        this.oglenList.add(new OglenItem("Beyti Kebabı(1 porsiyon)", "850 kcal",580));
        this.oglenList.add(new OglenItem("Paçanga Böreği(135 gr )", "504 kcal",504));
        this.oglenList.add(new OglenItem("İçli Köfte(1 adet)", "150 kcal",150));
        this.oglenList.add(new OglenItem("Su Böreği(1 porsiyon)", "450 kcal",450));
        this.oglenList.add(new OglenItem("Sigara Böreği(1 porsiyon)", "85 kcal",85));




        this.oglenList.add(new OglenItem("Portakal(1 adet) ", "50 kcal",50));
        this.oglenList.add(new OglenItem("Greyfurt(1 adet)", "60 kcal",60));
        this.oglenList.add(new OglenItem("Armut(1 adet)", "70 kcal",70));
        this.oglenList.add(new OglenItem("Elma(1 adet)", "60 kcal",60));
        this.oglenList.add(new OglenItem("Çilek(100 gr)", "26 kcal",26));
        this.oglenList.add(new OglenItem("İncir(100gr)", "41 kcal",41));
        this.oglenList.add(new OglenItem("Karpuz(1 ince dilim)", "40 kcal",40));
        this.oglenList.add(new OglenItem("Kivi(1 adet)", "34 kcal",34));
        this.oglenList.add(new OglenItem("Mandalina(1 adet)", "50 kcal",50));
        this.oglenList.add(new OglenItem("Muz (1 adet) ", "100 kcal",100));
        this.oglenList.add(new OglenItem("Şeftali(1 adet) ", "60 kcal",60));
        this.oglenList.add(new OglenItem("Üzüm(100 gr) ", "57 kcal",57));
        this.oglenList.add(new OglenItem("Kiraz(100 gr) ", "63 kcal",63));
        this.oglenList.add(new OglenItem("Ananas(100 gr) ", "56 kcal",56));
        this.oglenList.add(new OglenItem("Badem(100 gr) ", "600 kcal",600));
        this.oglenList.add(new OglenItem("Ceviz(100 gr) ", "549 kcal",549));
        this.oglenList.add(new OglenItem("Çam Fıstığı(100 gr) ", "600 kcal",600));
        this.oglenList.add(new OglenItem("Fındık(100 gr) ", "650 kcal",650));
        this.oglenList.add(new OglenItem("Fıstık(100 gr) ", "560 kcal",560));



    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById( R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        this.adapter = new OglenAdapter(this.oglenList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(this.adapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) { //girilen verilerin toplanması,toplam kcal hesabı
                        String ogun=intent.getStringExtra("ogun");
                        String ogunValueName=null;
                        if(ogun.equals("oglen")){
                            ogunValueName="oglenValue";
                        }
                        int ogunTotal=sharedPreferences.getInt(ogunValueName,0);
                        System.out.println("toplam:"+ogunTotal);
                        int currentCalValue=oglenList.get(position).getCalValue();
                        System.out.println("current:"+currentCalValue); //gereksiz
                        ogunTotal+=currentCalValue;
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putInt(ogunValueName,ogunTotal);
                        editor.apply();
                        Toast.makeText(getApplicationContext(), oglenList.get(position).getText2()+" eklendi.", Toast.LENGTH_LONG).show();
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        System.out.println("uzun tıklandı");  //gereksiz.
                    }
                })
        );

    }

    private void initToolbar() {   //toolbar içeriği
        setSupportActionBar((Toolbar) findViewById( R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Öğle Yemeği");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);// toolbardaki feri butonu

    }


    public void filterQuery(String text) {  //filtreleme
        ArrayList<OglenItem> filterdNames = new ArrayList<>();
        for (OglenItem s : this.oglenList) {
            if (s.getText1().toLowerCase().contains(text) || s.getText2().toLowerCase().contains(text)) {
                filterdNames.add(s);
            }
        }
        this.adapter.setFilter(filterdNames);
    }

}
