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

public class AksamActivity extends AppCompatActivity {

    Button aksamtemizlebutton;
    EditText Searchtext;
    private AksamAdapter adapter;
    ImageButton bt_mic;
    private List<AksamItem> aksamList;
    private List<AksamItem> examples;

    private Context context;
    SharedPreferences sharedPreferences;
    Intent intent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_aksam);
        this.context=getApplicationContext();
        this.intent = getIntent();
        fillAksamList();
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
                AksamActivity.this.filterQuery(editable.toString());
            }
        });

        aksamtemizlebutton=(Button)findViewById(R.id.aksamTemizle);  //temizle butonunda geri dönüşte 0 olması için
        aksamtemizlebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ogun=intent.getStringExtra("ogun");  // temizle butonuna basıldığında sıfırlanması için aşağıda yazdıklarımızı çektik.
                String ogunValueName=null;
                if(ogun.equals("aksam")){
                    ogunValueName="aksamValue";
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt(ogunValueName,0);
                editor.apply();
            }
        });

    }

    private void fillAksamList() {
        this.aksamList = new ArrayList();
        this.aksamList.add(new AksamItem("Adana Kebap (1 porsiyon)", "870 kcal",870));
        this.aksamList.add(new AksamItem("Al, Nazik (1 porsiyon)", "407 kcal",407));
        this.aksamList.add(new AksamItem("Kağıt Kebabı (1 porsiyon)", "139 kcal",139));
        this.aksamList.add(new AksamItem("Patlıcan Kebabı(1 porsiyon)", "276 kcal",276));
        this.aksamList.add(new AksamItem("İskender(1 porsiyon)", "970 kcal",970));
        this.aksamList.add(new AksamItem("Et Şiş(1 adet)", "120 kcal",120));
        this.aksamList.add(new AksamItem("Beyti Kebabı(1 porsiyon)", "850 kcal",580));
        this.aksamList.add(new AksamItem("Paçanga Böreği(135 gr )", "504 kcal",504));
        this.aksamList.add(new AksamItem("İçli Köfte(1 adet)", "150 kcal",150));
        this.aksamList.add(new AksamItem("Su Böreği(1 porsiyon)", "450 kcal",450));
        this.aksamList.add(new AksamItem("Sigara Böreği(1 porsiyon)", "85 kcal",85));
        this.aksamList.add(new AksamItem("Bezelye(1 porsiyon 100gr)", "289 kcal",289));
        this.aksamList.add(new AksamItem("Sulu Köfte(1 porsiyon 100gr)", "256 kcal",256));
        this.aksamList.add(new AksamItem("Mantı(1 porsiyon 100gr)", "341 kcal",341));
        this.aksamList.add(new AksamItem("Pizza(1 adet)", "584 kcal",584));
        this.aksamList.add(new AksamItem("Balık Tava (1 porsiyon 100gr)", "370 kcal",370));
        this.aksamList.add(new AksamItem("Talaş Böreği(1 porsiyon 100gr)", "360 kcal",360));
        this.aksamList.add(new AksamItem("Ayran (1 bardak 200ml)", "70 kcal",70));
        this.aksamList.add(new AksamItem("Etli pide (1 adet)", "570 kcal",570));
        this.aksamList.add(new AksamItem("Midye (1 adet)", "9 kcal",9));
        this.aksamList.add(new AksamItem("İstiridye (1 adet)", "6 kcal",6));
        this.aksamList.add(new AksamItem("IceTea(100 ml)", "27 kcal",27));
        this.aksamList.add(new AksamItem("Karides(1 adet)", "144 kcal",144));
        this.aksamList.add(new AksamItem("Somon Füme (100gr)", "171 kcal",171));
        this.aksamList.add(new AksamItem("Ton Balığı (100gr)", "121 kcal",121));
        this.aksamList.add(new AksamItem("Brokoli (100gr)", "35 kcal",35));
        this.aksamList.add(new AksamItem("Kereviz (100gr)", "18 kcal",18));
        this.aksamList.add(new AksamItem("Biftek Izgara (1 porsiyon 100gr)", "278 kcal",278));
        this.aksamList.add(new AksamItem("Tavuk Izgara (1 porsiyon 100gr)", "132 kcal",132));
        this.aksamList.add(new AksamItem("Kuzu Izgara (1 porsiyon 100gr)", "282 kcal",282));
        this.aksamList.add(new AksamItem("Nohut (1 porsiyon 100gr)", "364 kcal",364));
        this.aksamList.add(new AksamItem("Yeşil Mercimek (1 porsiyon 100gr)", "257 kcal",257));
        this.aksamList.add(new AksamItem("Biftek Izgara (1 porsiyon 100gr)", "278 kcal",278));
        this.aksamList.add(new AksamItem("Biftek Izgara (1 porsiyon 100gr)", "278 kcal",278));
        this.aksamList.add(new AksamItem("İmambayıldı(1 porsiyon 100gr)", "194 kcal",194));
        this.aksamList.add(new AksamItem("İzmir Köfte(1 porsiyon 100gr)", "348 kcal",348));
        this.aksamList.add(new AksamItem("Kabak Dolma(1 porsiyon 100gr)", "247 kcal",247));
        this.aksamList.add(new AksamItem("Rosto Et(1 porsiyon 100gr)", "311 kcal",311));
        this.aksamList.add(new AksamItem("Peynirli Makarna(1 porsiyon 100gr)", "354 kcal",354));
        this.aksamList.add(new AksamItem("Patlıcan Kebabı(1 porsiyon 100gr)", "406 kcal",406));
        this.aksamList.add(new AksamItem("Tepsi Börek(1 porsiyon 100gr)", "421 kcal",421));
        this.aksamList.add(new AksamItem("Kola(100 ml)", "42 kcal",42));
        this.aksamList.add(new AksamItem("Zeytinyağlı Fasülye(1 porsiyon 100gr)", "177 kcal",177));
        this.aksamList.add(new AksamItem("Kıymalı Biber Dolma(1 porsiyon 100gr)", "226 kcal",226));
        this.aksamList.add(new AksamItem("Zeytinyağlı Pırasa(1 porsiyon 100gr)", "225 kcal",225));
        this.aksamList.add(new AksamItem("Kıymalı Patates(1 porsiyon 100gr)", "250 kcal",250));
        this.aksamList.add(new AksamItem("Kuru Fasulye(1 porsiyon 100gr)", "336 kcal",336));
        this.aksamList.add(new AksamItem("Zeytinyağlı Bakla(1 porsiyon 100gr)", "266 kcal",266));
        this.aksamList.add(new AksamItem("Kuru Nohut(1 porsiyon 100gr)", "350 kcal",350));
        this.aksamList.add(new AksamItem("Limonata(100 ml)", "42 kcal",42));
        this.aksamList.add(new AksamItem("Zeytinyağlı Barbunya(1 porsiyon 100gr)", "328 kcal",328));
        this.aksamList.add(new AksamItem("Patlıcan Musakka(1 porsiyon 100gr)", "201 kcal",201));
        this.aksamList.add(new AksamItem("Kıymalı Ispanak(1 porsiyon 100gr)", "276 kcal",276));
        this.aksamList.add(new AksamItem("Kıymalı Bezelye(1 porsiyon 100gr)", "298 kcal",298));
        this.aksamList.add(new AksamItem("Kıymalı karnabahar(1 porsiyon 100gr)", "187 kcal",187));
        this.aksamList.add(new AksamItem("Kıymalı Kapuska(1 porsiyon 100gr)", "190 kcal",190));
        this.aksamList.add(new AksamItem("Pirinç Pilavı(1 porsiyon 100gr)", "326 kcal",326));
        this.aksamList.add(new AksamItem("Tas Kebabı(1 porsiyon 100gr)", "343 kcal",343));
        this.aksamList.add(new AksamItem("Yaz Türlüsü(1 porsiyon 100gr)", "221 kcal",221));
        this.aksamList.add(new AksamItem( "Bulgur Pilavı(1 porsiyon 100gr)", "291 kcal",291));
        this.aksamList.add(new AksamItem( "Cacık(1 porsiyon 100gr)", "191 kcal",191));
        this.aksamList.add(new AksamItem("Elma Komposto(1 bardak 200 ml)", "193 kcal",193));
        this.aksamList.add(new AksamItem("Gazoz(100 ml)", "42 kcal",42));
        this.aksamList.add(new AksamItem( "Fırın Makarna(1 porsiyon 100gr)", "505 kcal",505));
        this.aksamList.add(new AksamItem("Haşlanmış Tavuk(1 porsiyon 100gr)", "259 kcal",259));
        this.aksamList.add(new AksamItem("Havuç Salata(1 porsiyon 100gr)", "144 kcal",144));

        this.aksamList.add(new AksamItem("Portakal(1 adet) ", "50 kcal",50));
        this.aksamList.add(new AksamItem("Greyfurt(1 adet)", "60 kcal",60));
        this.aksamList.add(new AksamItem("Armut(1 adet)", "70 kcal",70));
        this.aksamList.add(new AksamItem("Elma(1 adet)", "60 kcal",60));
        this.aksamList.add(new AksamItem("Çilek(100 gr)", "26 kcal",26));
        this.aksamList.add(new AksamItem("İncir(100gr)", "41 kcal",41));
        this.aksamList.add(new AksamItem("Karpuz(1 ince dilim)", "40 kcal",40));
        this.aksamList.add(new AksamItem("Kivi(1 adet)", "34 kcal",34));
        this.aksamList.add(new AksamItem("Mandalina(1 adet)", "50 kcal",50));
        this.aksamList.add(new AksamItem("Muz (1 adet) ", "100 kcal",100));
        this.aksamList.add(new AksamItem("Şeftali(1 adet) ", "60 kcal",60));
        this.aksamList.add(new AksamItem("Üzüm(100 gr) ", "57 kcal",57));
        this.aksamList.add(new AksamItem("Kiraz(100 gr) ", "63 kcal",63));
        this.aksamList.add(new AksamItem("Ananas(100 gr) ", "56 kcal",56));
        this.aksamList.add(new AksamItem("Badem(100 gr) ", "600 kcal",600));
        this.aksamList.add(new AksamItem("Ceviz(100 gr) ", "549 kcal",549));
        this.aksamList.add(new AksamItem("Çam Fıstığı(100 gr) ", "600 kcal",600));
        this.aksamList.add(new AksamItem("Fındık(100 gr) ", "650 kcal",650));
        this.aksamList.add(new AksamItem("Fıstık(100 gr) ", "560 kcal",560));
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById( R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        this.adapter = new AksamAdapter(this.aksamList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(this.adapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) { //girilen verilerin toplanması,toplam kcal hesabı
                        String ogun=intent.getStringExtra("ogun");
                        String ogunValueName=null;
                        if(ogun.equals("aksam")){
                            ogunValueName="aksamValue";
                        }
                        int ogunTotal=sharedPreferences.getInt(ogunValueName,0);
                        System.out.println("toplam:"+ogunTotal); //gereksiz.
                        int currentCalValue=aksamList.get(position).getCalValue();
                        System.out.println("current:"+currentCalValue); //gereksiz
                        ogunTotal+=currentCalValue;
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putInt(ogunValueName,ogunTotal);
                        editor.apply();
                        Toast.makeText(getApplicationContext(), aksamList.get(position).getText2()+" eklendi.", Toast.LENGTH_LONG).show();
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        System.out.println("uzun tıklandı");  //gereksiz.
                    }
                })
        );

    }

    private void initToolbar() {   //toolbar içeriği
        setSupportActionBar((Toolbar) findViewById( R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Akşam Yemeği");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);  // toolbardaki feri butonu

    }


    public void filterQuery(String text) {  //filtreleme
        ArrayList<AksamItem> filterdNames = new ArrayList<>();
        for (AksamItem s : this.aksamList) {
            if (s.getText1().toLowerCase().contains(text) || s.getText2().toLowerCase().contains(text)) {
                filterdNames.add(s);
            }
        }
        this.adapter.setFilter(filterdNames);
    }

}
