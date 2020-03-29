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
@SuppressWarnings("unchecked")
public class KahvaltiActivity extends AppCompatActivity {

    Button temizlebutton;
    EditText Searchtext;
    private KahvaltiAdapter adapter;
    ImageButton bt_mic;
    private List<KahvaltiItem> kahvaltiList;
    private List<KahvaltiItem> examples;

    private Context context;
    SharedPreferences sharedPreferences;
    Intent intent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_kahvalti);
        this.context=getApplicationContext();
        this.intent = getIntent();
        fillKahvaltiList();
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
                KahvaltiActivity.this.filterQuery(editable.toString());
            }
        });

        temizlebutton=(Button)findViewById(R.id.kahvaltiTemizle);  //temizle butonunda geri dönüşte 0 olması için
        temizlebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ogun=intent.getStringExtra("ogun");
                String ogunValueName=null;
                if(ogun.equals("kahvaltı")){
                    ogunValueName="kahvaltıValue";
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt(ogunValueName,0);
                editor.apply();
            }
        });

    }

    private void fillKahvaltiList() {
        this.kahvaltiList = new ArrayList();
        this.kahvaltiList.add(new KahvaltiItem( "Beyaz Ekmek(1 dilim)", "66 kcal",66));
        this.kahvaltiList.add(new KahvaltiItem( "Kızarmış Beyaz Ekmek(1 dilim)", "64 kcal",64));
        this.kahvaltiList.add(new KahvaltiItem("Kepekli Ekmek", "67 kcal",67));
        this.kahvaltiList.add(new KahvaltiItem( "Kaşar Peynir(45 gr)", "152 kcal",152));
        this.kahvaltiList.add(new KahvaltiItem("Beyaz Peynir (100 gr)", "204 kcal",204));
        this.kahvaltiList.add(new KahvaltiItem("Krem Peynir(1 yemek kaşığı)", "51 kcal",51));
        this.kahvaltiList.add(new KahvaltiItem("Yağlı Peynir(100 gr)", "224 kcal",224));
        this.kahvaltiList.add(new KahvaltiItem("Tereyağ(1 yemek kaşığı)", "102 kcal",102));
        this.kahvaltiList.add(new KahvaltiItem("Haşlanmış Yumurta", "78 kcal",78));
        this.kahvaltiList.add(new KahvaltiItem("Yumurta Sarısı", "65 kcal",65));
        this.kahvaltiList.add(new KahvaltiItem("Yumurta Beyazı", "13 kcal",13));
        this.kahvaltiList.add(new KahvaltiItem("Sucuklu Yumurta(1 porsiyon,150 gr)", "348 kcal",348));
        this.kahvaltiList.add(new KahvaltiItem("Vişne Reçeli(1 yemek kaşığı)", "24 kcal",24));
        this.kahvaltiList.add(new KahvaltiItem("Kayısı Reçeli(1 yemek kaşığı)", "48 kcal",48));
        this.kahvaltiList.add(new KahvaltiItem("Bal(1 yemek kaşığı)", "64 kcal",64));
        this.kahvaltiList.add(new KahvaltiItem("Süt(1 Bardak)", "122 kcal",122));
        this.kahvaltiList.add(new KahvaltiItem("Çikolatalı Süt(100 ml)", "68 kcal",68));
        this.kahvaltiList.add(new KahvaltiItem("Ballı Süt(100 ml)", "70 kcal",70));
        this.kahvaltiList.add(new KahvaltiItem("Çörek", "148 kcal",148));
        this.kahvaltiList.add(new KahvaltiItem("Simit", "276 kcal",276));
        this.kahvaltiList.add(new KahvaltiItem("Kaşarlı Tost", "270 kcal",270));
        this.kahvaltiList.add(new KahvaltiItem("Ayvalık Tostu", "751 kcal",751));
        this.kahvaltiList.add(new KahvaltiItem("Yulaf Ezmesi(100 gr)", "367 kcal",367));
        this.kahvaltiList.add(new KahvaltiItem("Pide(100 gr)", "223 kcal",223));
        this.kahvaltiList.add(new KahvaltiItem("Vişne Reçeli(1 yemek kaşığı)", "24 kcal",24));
        this.kahvaltiList.add(new KahvaltiItem("Çay(200 ml)", "2 kcal",2));
        this.kahvaltiList.add(new KahvaltiItem("Şekerli Çay(100 ml)", "20 kcal",20));
        this.kahvaltiList.add(new KahvaltiItem("Nutella(1 yemek kaşığı)", "65 kcal",65));
        this.kahvaltiList.add(new KahvaltiItem("Dana Jambon(30 gr)", "123 kcal",123));
        this.kahvaltiList.add(new KahvaltiItem("Elma Suyu(250 ml)", "117 kcal",117));
        this.kahvaltiList.add(new KahvaltiItem("Portakal Suyu(100 ml) ", "45 kcal",45));
        this.kahvaltiList.add(new KahvaltiItem("Zeytin(50 gr)", "116 kcal",116));
        this.kahvaltiList.add(new KahvaltiItem("Filtre Kahve(240 ml)", "2 kcal",2));
        this.kahvaltiList.add(new KahvaltiItem("Kornfleks(20 gr)", "76 kcal",76));
        this.kahvaltiList.add(new KahvaltiItem("Pastırma(30 gr)", "75 kcal",75));
        this.kahvaltiList.add(new KahvaltiItem("Pekmez(1 yemek kaşığı)", "60 kcal",60));
        this.kahvaltiList.add(new KahvaltiItem("Sucuk(30 gr)", "135 kcal",135));
        this.kahvaltiList.add(new KahvaltiItem("Küp Şeker(2.8 gr)", "9 kcal",9));
        this.kahvaltiList.add(new KahvaltiItem("Yeşil Zeytin(50 gr)", "73 kcal",73));
        this.kahvaltiList.add(new KahvaltiItem("Fıstık Ezmesi(1 yemek kaşığı)", "156 kcal",156));
        this.kahvaltiList.add(new KahvaltiItem("Omlet(1 yumurta)", "93 kcal",93));
        this.kahvaltiList.add(new KahvaltiItem("Patates Kızartması(100 gr)", "319 kcal",319));
        this.kahvaltiList.add(new KahvaltiItem("Yoğurt(100 gr)", "95 kcal",95));


        //tüm öğünlere eklenebilir.
        this.kahvaltiList.add(new KahvaltiItem("Portakal(1 adet) ", "50 kcal",50));
        this.kahvaltiList.add(new KahvaltiItem("Greyfurt(1 adet)", "60 kcal",60));
        this.kahvaltiList.add(new KahvaltiItem("Armut(1 adet)", "70 kcal",70));
        this.kahvaltiList.add(new KahvaltiItem("Elma(1 adet)", "60 kcal",60));
        this.kahvaltiList.add(new KahvaltiItem("Çilek(100 gr)", "26 kcal",26));
        this.kahvaltiList.add(new KahvaltiItem("İncir(100gr)", "41 kcal",41));
        this.kahvaltiList.add(new KahvaltiItem("Karpuz(1 ince dilim)", "40 kcal",40));
        this.kahvaltiList.add(new KahvaltiItem("Kivi(1 adet)", "34 kcal",34));
        this.kahvaltiList.add(new KahvaltiItem("Mandalina(1 adet)", "50 kcal",50));
        this.kahvaltiList.add(new KahvaltiItem("Muz (1 adet) ", "100 kcal",100));
        this.kahvaltiList.add(new KahvaltiItem("Şeftali(1 adet) ", "60 kcal",60));
        this.kahvaltiList.add(new KahvaltiItem("Üzüm(100 gr) ", "57 kcal",57));
        this.kahvaltiList.add(new KahvaltiItem("Kiraz(100 gr) ", "63 kcal",63));
        this.kahvaltiList.add(new KahvaltiItem("Ananas(100 gr) ", "56 kcal",56));
        this.kahvaltiList.add(new KahvaltiItem("Badem(100 gr) ", "600 kcal",600));
        this.kahvaltiList.add(new KahvaltiItem("Ceviz(100 gr) ", "549 kcal",549));
        this.kahvaltiList.add(new KahvaltiItem("Çam Fıstığı(100 gr) ", "600 kcal",600));
        this.kahvaltiList.add(new KahvaltiItem("Fındık(100 gr) ", "650 kcal",650));
        this.kahvaltiList.add(new KahvaltiItem("Fıstık(100 gr) ", "560 kcal",560));













    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById( R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        this.adapter = new KahvaltiAdapter(this.kahvaltiList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(this.adapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) { //girilen verilerin toplanması,toplam kcal hesabı
                        String ogun=intent.getStringExtra("ogun");
                        String ogunValueName=null;
                        if(ogun.equals("kahvaltı")){
                            ogunValueName="kahvaltıValue";
                        }
                        int ogunTotal=sharedPreferences.getInt(ogunValueName,0);
                        System.out.println("toplam:"+ogunTotal);
                        int currentCalValue=kahvaltiList.get(position).getCalValue();
                        System.out.println("current:"+currentCalValue); //gereksiz
                        ogunTotal+=currentCalValue;
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putInt(ogunValueName,ogunTotal);
                        editor.apply();
                        Toast.makeText(getApplicationContext(), kahvaltiList.get(position).getText2()+" eklendi.", Toast.LENGTH_LONG).show();
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        System.out.println("uzun tıklandı");  //gereksiz.
                    }
                })
        );

    }

    private void initToolbar() {   //toolbar içeriği
        setSupportActionBar((Toolbar) findViewById( R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Kahvaltı");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);// toolbardaki feri butonu

    }


    public void filterQuery(String text) {  //filtreleme
        ArrayList<KahvaltiItem> filterdNames = new ArrayList<>();
        for (KahvaltiItem s : this.kahvaltiList) {
            if (s.getText1().toLowerCase().contains(text) || s.getText2().toLowerCase().contains(text)) {
                filterdNames.add(s);
            }
        }
        this.adapter.setFilter(filterdNames);
    }

}
